package HealthMonitorMng.hbm.base.background;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserLog implements Serializable{
		private String logId;
		private String active;
		private String content;
		private Timestamp time;
		private String detail;
		private String userName;
		private String loginIp;
		private String operationIp;
		
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getLoginIp() {
			return loginIp;
		}
		public void setLoginIp(String loginIp) {
			this.loginIp = loginIp;
		}
		public String getOperationIp() {
			return operationIp;
		}
		public void setOperationIp(String operationIp) {
			this.operationIp = operationIp;
		}
		public String getLogId() {
			return logId;
		}
		public void setLogId(String logId) {
			this.logId = logId;
		}
		public String getActive() {
			return active;
		}
		public void setActive(String active) {
			this.active = active;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public Timestamp getTime() {
			return time;
		}
		public void setTime(Timestamp time) {
			this.time = time;
		}
		public String getDetail() {
			return detail;
		}
		public void setDetail(String detail) {
			this.detail = detail;
		}
		
}
