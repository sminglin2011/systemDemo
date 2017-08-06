package com.sm.system.domain.number;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 功能描述:序列号表模型
 *
 */
@Entity
@Table(name="sys_serial_number")
public class SystemSerialNumber {
	@Id @GeneratedValue
	private Integer id;

    /**
     * 模块名称
     */
    @Column(name = "module_name")
    private String moduleName;

    /**
     * 模块编码
     */
    @Column(name = "module_code")
    private String moduleCode;

    /**
     * 流水号配置模板
     */
    @Column(name = "config_templet")
    private String configTemplet;

    /**
     * 序列号最大值
     */
    @Column(name = "max_serial")
    private String maxSerial;

    /**
     * 是否自动增长标示
     */
    @Column(name = "is_auto_increment")
    private String isAutoIncrement;

    public String getIsAutoIncrement() {
        return isAutoIncrement;
    }

    public void setIsAutoIncrement(String isAutoIncrement) {
        this.isAutoIncrement = isAutoIncrement;
    }

    /**
     * 预生成流水号数量
     */
    @Column(name = "pre_max_num")
    private String preMaxNum;

    public String getPreMaxNum() {
        return preMaxNum;
    }

    public void setPreMaxNum(String preMaxNum) {
        this.preMaxNum = preMaxNum;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getConfigTemplet() {
        return configTemplet;
    }

    public void setConfigTemplet(String configTemplet) {
        this.configTemplet = configTemplet;
    }

    public String getMaxSerial() {
        return maxSerial;
    }

    public void setMaxSerial(String maxSerial) {
        this.maxSerial = maxSerial;
    }

    public SystemSerialNumber(Integer id){
        this.id = id;
    }

    public  SystemSerialNumber(Integer id,String moduleCode){
        this.id = id;
        this.moduleCode = moduleCode;
    }

    public SystemSerialNumber(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}