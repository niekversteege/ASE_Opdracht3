package nl.han.minor.ase.dare2date.message;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import nl.han.minor.ase.dare2date.types.DateSuggestion;
@XmlRootElement(name="DateSuggestionResponse",namespace="http://dare2date.com/dd/")
@XmlAccessorType
@XmlType
public class DateSuggestionResponse implements Serializable {

	public DateSuggestionResponse() {
	}

	private DateSuggestion datesuggestion;

	public DateSuggestionResponse(DateSuggestion datesuggestion) {
		this.datesuggestion = datesuggestion;
	}

	public DateSuggestion getDateSuggestion() {
		return datesuggestion;
	}

	public void setDateSuggestion(DateSuggestion memberdetail) {
		this.datesuggestion = memberdetail;
	}

}