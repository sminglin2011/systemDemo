package com.sm.system.service.account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sm.system.constant.StaticParams;
import com.sm.system.domain.accountant.ChartOfAccount;
import com.sm.system.domain.accountant.ChartOfAccountRepository;
import com.sm.system.domain.accountant.GeneralLedgerType;
import com.sm.system.domain.accountant.GeneralLedgerTypeRepository;
import com.sm.system.domain.parameter.SystemParameter;
import com.sm.system.exception.MyException;
import com.sm.system.service.parameter.ParameterService;
import com.sm.system.util.CollectionUtil;
import com.sm.system.util.SystemUtil;

@Service("coaService")
public class ChartOfAccountServiceImpl implements ChartOfAccountService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name="ChartOfAccountRepository")
	private ChartOfAccountRepository repository;
	@Resource(name="GeneralLedgerService")
	private GeneralLedgerService glSvc;
	@Resource(name="ParameterServiceImpl")
	private ParameterService paramSvc;

	@Override
	public List<ChartOfAccount> findAll() throws MyException{
		return repository.findAll();
	}

	@Override
	public ChartOfAccount save(ChartOfAccount entity) throws MyException {
		try {
			entity = repository.save(entity);
		} catch (RuntimeException e) {
			log.error(e.getLocalizedMessage());
			e.printStackTrace();
			if(e.getMessage().indexOf("[UK_") > 0) {
				throw new MyException("Duplicate Ledger Code");
			} else {
				throw new MyException(e.getLocalizedMessage());
			}
			
		}
		return entity;
	}

	@Override
	public ChartOfAccount findOne(String id) {
		ChartOfAccount coa = repository.findOne(Integer.valueOf(id));
		return coa;
	}

	@Override
	public List<ChartOfAccount> initChartOfAccount() throws MyException {
		SystemParameter systemCurrencyParam = paramSvc.findByName("SYSTEM_CURRENCY");
		String systemCurrency = (SystemUtil.isEmpty(systemCurrencyParam.getKeyValue())) ? "S$" : systemCurrencyParam.getKeyValue();
		List<ChartOfAccount> list  = new ArrayList<>();
		if (repository.count() < 1) {
			
			GeneralLedgerType assets = glSvc.findByClassification("ASSETS");
			ChartOfAccount bank = new ChartOfAccount(10100, "Bank", assets, "NA", systemCurrency);
			list.add(bank);
			
			ChartOfAccount cash = new ChartOfAccount(10600, "Petty Cash", assets, "NA", systemCurrency);
			list.add(cash);
			
			ChartOfAccount ar = new ChartOfAccount(12100, "Accounts Receivable", assets, "NA", systemCurrency);
			ar.setDebit(true);
			list.add(ar);
			
			ChartOfAccount allowance = new ChartOfAccount(12500, "Allowance for Doubtful Accounts", assets, "NA", systemCurrency);
			list.add(allowance);
			
			ChartOfAccount Inventory = new ChartOfAccount(13100, "Inventory", assets, "NA", systemCurrency);
			list.add(Inventory);
			
			ChartOfAccount Supplies = new ChartOfAccount(14100, "Supplies", assets, "NA", systemCurrency);
			list.add(Supplies);
			
			ChartOfAccount PrepaidInsurance = new ChartOfAccount(15300, "Prepaid Insurance", assets, "NA", systemCurrency);
			list.add(PrepaidInsurance);
			
			ChartOfAccount Land = new ChartOfAccount(17000, "Land", assets, "NA", systemCurrency);
			list.add(Land);
			
			ChartOfAccount Buildings = new ChartOfAccount(17100, "Buildings", assets, "NA", systemCurrency);
			list.add(Buildings);
			
			ChartOfAccount Equipment = new ChartOfAccount(17300, "Equipment", assets, "NA", systemCurrency);
			list.add(Equipment);
			
			ChartOfAccount Vehicles = new ChartOfAccount(17800, "Vehicles", assets, "NA", systemCurrency);
			list.add(Vehicles);
			
			ChartOfAccount AccumulatedDepreciationBuildings = new ChartOfAccount(18100, "Accumulated Depreciation - Buildings", assets, "NA", systemCurrency);
			list.add(AccumulatedDepreciationBuildings);
			
			ChartOfAccount AccumulatedDepreciationEquipment = new ChartOfAccount(18300, "Accumulated Depreciation - Equipment", assets, "NA", systemCurrency);
			list.add(AccumulatedDepreciationEquipment);
			
			ChartOfAccount AccumulatedDepreciationVehicles = new ChartOfAccount(18800, "Accumulated Depreciation - Vehicles", assets, "NA", systemCurrency);
			list.add(AccumulatedDepreciationVehicles);
			
			GeneralLedgerType liability = glSvc.findByClassification("LIABILITY");
			
			ChartOfAccount notesPayable = new ChartOfAccount(20130, "Notes Payable - Credit Line #1", liability, "NA", systemCurrency);
			list.add(notesPayable);
			
			ChartOfAccount AccountsPayable = new ChartOfAccount(21000, "Accounts Payable", liability, "NA", systemCurrency);
			AccountsPayable.setCredit(true);
			list.add(AccountsPayable);
			
			ChartOfAccount WagesPayable = new ChartOfAccount(22100, "Wages Payable", liability, "NA", systemCurrency);
			list.add(WagesPayable);
			
			ChartOfAccount InterestPayable = new ChartOfAccount(23100, "Interest Payable", liability, "NA", systemCurrency);
			list.add(InterestPayable);
			
			ChartOfAccount UnearneRevenues = new ChartOfAccount(24500, "Unearned Revenues", liability, "NA", systemCurrency);
			list.add(UnearneRevenues);
			
			ChartOfAccount MortgageLoanPayable = new ChartOfAccount(25100, "Mortgage Loan Payable", liability, "NA", systemCurrency);
			list.add(MortgageLoanPayable);
			
			ChartOfAccount BondsPayable = new ChartOfAccount(25600, "Bonds Payable", liability, "NA", systemCurrency);
			list.add(BondsPayable);
			
			ChartOfAccount DiscountOnBondsPayable = new ChartOfAccount(25650, "Discount on Bonds Payable", liability, "NA", systemCurrency);
			list.add(DiscountOnBondsPayable);
			
			ChartOfAccount gstInput = new ChartOfAccount(26100, "GST Input", liability, "NA", systemCurrency);
			gstInput.setInputGst(true);
			list.add(gstInput);
			ChartOfAccount gstOutput = new ChartOfAccount(26200, "GST Output", liability, "NA", systemCurrency);
			gstOutput.setOutputGst(true);
			list.add(gstOutput);
			ChartOfAccount gstCtrl = new ChartOfAccount(26300, "GST Control", liability, "NA", systemCurrency);
			list.add(gstCtrl);
			
			GeneralLedgerType Equity = glSvc.findByClassification("EQUITY");
			ChartOfAccount RetainedEarnings = new ChartOfAccount(27500, "Retained Earnings", Equity, "NA", systemCurrency);
			RetainedEarnings.setRetainEarning(true);
			list.add(RetainedEarnings);
			
			GeneralLedgerType Sales = glSvc.findByClassification("SALES");
			ChartOfAccount sales1 = new ChartOfAccount(31010, "Sales - Division #1, Product Line 010", Sales, "NA", systemCurrency);
			sales1.setGstRevenue(true);
			list.add(sales1);
			
			ChartOfAccount sales2 = new ChartOfAccount(31020, "Sales - Division #1, Product Line 020", Sales, "NA", systemCurrency);
			sales2.setGstRevenue(true);
			list.add(sales2);
			
			ChartOfAccount sales3 = new ChartOfAccount(31030, "Sales - Division #1, Product Line 030", Sales, "NA", systemCurrency);
			sales3.setGstRevenue(true);
			list.add(sales3);
			
			GeneralLedgerType COGS = glSvc.findByClassification("COST-OF-GOODS-SOLD");
			ChartOfAccount cogs1 = new ChartOfAccount(41010, "COGS - Division #1, Product Line 010", COGS, "NA", systemCurrency);
			list.add(cogs1);
			
			ChartOfAccount cogs2 = new ChartOfAccount(41020, "COGS - Division #1, Product Line 020", COGS, "NA", systemCurrency);
			list.add(cogs2);
			
			ChartOfAccount cogs3 = new ChartOfAccount(41030, "COGS - Division #1, Product Line 030", COGS, "NA", systemCurrency);
			list.add(cogs3);
			
			GeneralLedgerType Expenses = glSvc.findByClassification("EXPENSES");
			ChartOfAccount Expenses1 = new ChartOfAccount(50100, "Marketing Dept. Salaries", Expenses, "NA", systemCurrency);
			list.add(Expenses1);
			
			ChartOfAccount Expenses2 = new ChartOfAccount(50200, "Marketing Dept. Supplies", Expenses, "NA", systemCurrency);
			list.add(Expenses2);
			
			ChartOfAccount Expenses3 = new ChartOfAccount(50300, "Marketing Dept. Telephone", Expenses, "NA", systemCurrency);
			list.add(Expenses3);
			
			ChartOfAccount Expenses4 = new ChartOfAccount(50400, "Marketing Dept. Payroll Taxes", Expenses, "NA", systemCurrency);
			list.add(Expenses4);
			
			list = repository.save(list);
		}
		
		
		
		return list;
	}

	
}
