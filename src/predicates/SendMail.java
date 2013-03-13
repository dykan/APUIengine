package predicates;

import com.guilhermechapiewski.fluentmail.email.EmailMessage;
import com.guilhermechapiewski.fluentmail.transport.EmailTransportConfiguration;

import types.FlowData;
import types.Predicate;

public class SendMail implements Predicate{

	public String toEmailAddress;
	public String fromEmailAddress;
	public String subject;
	public String getToEmailAddress() {
		return toEmailAddress;
	}

	public void setToEmailAddress(String toEmailAddress) {
		this.toEmailAddress = toEmailAddress;
	}

	public String getFromEmalAddress() {
		return fromEmailAddress;
	}

	public void setFromEmalAddress(String fromEmalAddress) {
		this.fromEmailAddress = fromEmalAddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSmtpServer() {
		return smtpServer;
	}

	public void setSmtpServer(String smtpServer) {
		this.smtpServer = smtpServer;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String body;
	public String smtpServer;
	public String userName;
	public String password;

	@Override
	public String getLabel() {
		return "Sending a mail";
	}

	@Override
	public Class[] getInputTypes() {
		return null;
	}

	@Override
	public boolean execute(FlowData data) {
		EmailTransportConfiguration.configure(smtpServer, true, false, userName, password);
		
		new EmailMessage()
	    .from(fromEmailAddress)
	    .to(toEmailAddress)
	    .withSubject(subject)
	    .withBody(body)
	    .send();
		return true;
	}

}
