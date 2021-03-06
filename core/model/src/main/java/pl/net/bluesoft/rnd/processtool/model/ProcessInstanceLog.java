package pl.net.bluesoft.rnd.processtool.model;

import org.hibernate.annotations.Type;
import pl.net.bluesoft.rnd.processtool.model.config.ProcessStateConfiguration;

import javax.persistence.*;
import java.util.Calendar;

import static pl.net.bluesoft.util.lang.FormatUtil.nvl;

/**
 * @author tlipski@bluesoft.net.pl
 */
@Entity
@Table(name = "pt_process_instance_log")
public class ProcessInstanceLog extends PersistentEntity implements Comparable {

	public static final String LOG_TYPE_START_PROCESS = "START_PROCESS";
	public static final String LOG_TYPE_CLAIM_PROCESS = "CLAIM_PROCESS";
	public static final String LOG_TYPE_PERFORM_ACTION = "PERFORM_ACTION";
	public static final String LOG_TYPE_INFO = "INFO";

	private Calendar entryDate;

	private String eventI18NKey;

	@Lob
//    @Type(type = "org.hibernate.type.MaterializedClobType")
    @Type(type = "org.hibernate.type.StringClobType")
    @Column(length = Integer.MAX_VALUE)
	private String additionalInfo;

	private String logValue;
	private String logType;

	@ManyToOne
	@JoinColumn(name="process_state_id")
	private ProcessStateConfiguration state;

	@ManyToOne
	@JoinColumn(name="process_instance_id")
	private ProcessInstance processInstance;


	@ManyToOne
	@JoinColumn(name="user_id")
	private UserData user;

    @ManyToOne
	@JoinColumn(name="user_substitute_id")
	private UserData userSubstitute;

	public ProcessInstanceLog() {
	}

	public Calendar getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Calendar entryDate) {
		this.entryDate = entryDate;
	}

	public String getEventI18NKey() {
		return eventI18NKey;
	}

	public void setEventI18NKey(String eventI18NKey) {
		this.eventI18NKey = eventI18NKey;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public ProcessStateConfiguration getState() {
		return state;
	}

	public void setState(ProcessStateConfiguration state) {
		this.state = state;
	}

	public ProcessInstance getProcessInstance() {
		return processInstance;
	}

	public void setProcessInstance(ProcessInstance processInstance) {
		this.processInstance = processInstance;
	}

	public void setUser(UserData user) {
		this.user = user;
	}

	public UserData getUser() {
		return user;
	}

    public UserData getUserSubstitute() {
        return userSubstitute;
    }

    public void setUserSubstitute(UserData userSubstitute) {
        this.userSubstitute = userSubstitute;
    }

    public String getLogValue() {
		return logValue;
	}

	public void setLogValue(String logValue) {
		this.logValue = logValue;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	@Override
	public int compareTo(Object o) {
		if (!(o instanceof ProcessInstanceLog))
			throw new IllegalArgumentException(o + " is not an instance of " + ProcessInstanceLog.class.getName());
		return nvl(((ProcessInstanceLog)o).getEntryDate(), Calendar.getInstance()).compareTo(nvl(entryDate, Calendar.getInstance()));
	}
}
