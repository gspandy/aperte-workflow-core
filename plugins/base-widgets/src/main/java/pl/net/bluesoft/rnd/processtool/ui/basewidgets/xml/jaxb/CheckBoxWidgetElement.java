package pl.net.bluesoft.rnd.processtool.ui.basewidgets.xml.jaxb;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import pl.net.bluesoft.rnd.processtool.ui.widgets.annotations.AperteDoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
//@XmlRootElement(name = "checkbox")
@XStreamAlias("checkbox")
public class CheckBoxWidgetElement extends WidgetElement {
    @XmlAttribute
    @XStreamAsAttribute
    @AperteDoc(humanNameKey = "checkbox.defaultSelect", descriptionKey = "checkbox.defaultSelect.description")
    private Boolean defaultSelect;

    public Boolean getDefaultSelect() {
        return defaultSelect;
    }

    public void setDefaultSelect(Boolean defaultSelect) {
        this.defaultSelect = defaultSelect;
    }
}
