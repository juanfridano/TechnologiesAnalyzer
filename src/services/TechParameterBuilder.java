package services;

import java.util.Date;
import java.util.List;

public class TechParameterBuilder {

	private TechParameters product;

	public TechParameterBuilder() {
		product = new TechParameters();
	}

	public TechParameters build() {
		return product;
	}

	public TechParameterBuilder setFirma(String firma) {
		product.firma = firma;
		return this;
	}

	public TechParameterBuilder setRequestTitle(String requestTitle) {
		product.requestTitle = requestTitle;
		return this;
	}

	public TechParameterBuilder setMessageDate(Date messageDate) {
		product.messageDate = messageDate;
		return this;
	}

	public TechParameterBuilder setSourceName(String sourceName) {
		product.sourceName = sourceName;
		return this;
	}

	public TechParameterBuilder setDomain(String domain) {
		product.domain = domain;
		return this;
	}

	public TechParameterBuilder setLink(String link) {
		product.link = link;
		return this;
	}


	public TechParameterBuilder setCategories(List<String> categories) {
		product.categories = categories;
		return this;
	}

	public static class TechParameters {

		private String firma;
		private String requestTitle;
		private String link;
		private Date messageDate;
		private String sourceName;
		private String domain;
		private List<String> categories;

		public String getFirma() {
			return firma;
		}

		public String getRequestTitle() {
			return requestTitle;
		}

		public String getLink() {
			return link;
		}

		
		public Date getMessageDate() {
			return messageDate;
		}

		public String getSourceName() {
			return sourceName;
		}

		public String getDomain() {
			return domain;
		}

		public List<String> getCategories() {
			return categories;
		}
	}
}
