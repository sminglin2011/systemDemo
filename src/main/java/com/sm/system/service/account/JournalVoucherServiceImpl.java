package com.sm.system.service.account;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sm.system.domain.NumberCtrlRepository;
import com.sm.system.domain.accountant.JournalVoucher;
import com.sm.system.domain.accountant.JournalVoucherItem;
import com.sm.system.domain.accountant.JournalVoucherRepository;
import com.sm.system.domain.parameter.SystemParameter;
import com.sm.system.exception.MyException;
import com.sm.system.service.parameter.ParameterService;

@Service("JournalVoucherService")
public class JournalVoucherServiceImpl implements JournalVoucherService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name="JournalVoucherRepository")
	private JournalVoucherRepository repository;
	@Resource(name="NumberCtrlService")
	private NumberCtrlService numberCtrlSvc;
	@Resource(name="ParameterServiceImpl")
	private ParameterService parameterSvc;
	
	@Override
	public List<JournalVoucher> findAll() {
		log.debug(".........get all journal voucher..............");
		return repository.findAll();
	}
	@Override
	public JournalVoucher findOne(String id) {
		if (id == null || id.equals("0")) return new JournalVoucher();
		JournalVoucher jv = repository.findOne(Integer.valueOf(id));
		return jv;
	}
	
	@Override
	public JournalVoucher save(JournalVoucher journal) throws MyException {
		try {
			List<JournalVoucherItem> items = journal.getItems();
			for(JournalVoucherItem item: items){
				item.setJournalVoucher(journal);
			}
			journal = repository.save(journal);
			if(journal.getVoucherNo() == null || journal.getVoucherNo().equals("")) {
				if(journal.getDate() == null) throw new MyException("Journal Voucher Date cannot empty");
				// 获取 journal number
				SystemParameter journalVoucherPrefix = parameterSvc.findByName("JOURNAL-VOUCHER-NUMBER-PREFIX");
				journal.setVoucherNo(numberCtrlSvc.getNextNo(
						journalVoucherPrefix.getKeyValue()==null ? "JV" : journalVoucherPrefix.getKeyValue()
							, journal.getDate()));
			}
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			e.printStackTrace();
			throw new MyException("save journal voucher error");
		}
		return journal;
	}
	
	
}
