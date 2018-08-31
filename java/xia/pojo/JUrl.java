package java.xia.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="joburl")
public class JUrl {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//主键自增长策略
	private Long urlId;
	
	@Column(name="url")
	private String url;

	public Long getUrlId() {
		return urlId;
	}

	public void setUrlId(Long urlId) {
		this.urlId = urlId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
