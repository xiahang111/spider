package java.xia.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="msg")
public class JobMsg {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//主键自增长策略
	private Long JobMsgId; //工作ID
	
	@Column(name="JobPost")
	private String JobPost; //工作行业
	
	@Column(name="JobPlace")
	private String JobPlace; //工作地点
	
	@Column(name="JobEdu")
	private String JobEdu; //学历要求
	
	@Column(name="JobSalary")
	private String JobSalary; //薪资情况
	
	@Column(name="JobDec")
	private String JobDec; //工作描述
	public Long getJobMsgId() {
		return JobMsgId;
	}
	public void setJobMsgId(Long jobMsgId) {
		JobMsgId = jobMsgId;
	}
	public String getJobPost() {
		return JobPost;
	}
	public void setJobPost(String jobPost) {
		JobPost = jobPost;
	}
	public String getJobPlace() {
		return JobPlace;
	}
	public void setJobPlace(String jobPlace) {
		JobPlace = jobPlace;
	}
	public String getJobEdu() {
		return JobEdu;
	}
	public void setJobEdu(String jobEdu) {
		JobEdu = jobEdu;
	}
	public String getJobSalary() {
		return JobSalary;
	}
	public void setJobSalary(String jobSalary) {
		JobSalary = jobSalary;
	}
	public String getJobDec() {
		return JobDec;
	}
	public void setJobDec(String jobDec) {
		JobDec = jobDec;
	}
	
	

}
