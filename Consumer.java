@XmlRootElement(name = "consumer")

public class Consumer {
    private Integer consumerId;
    private String consumerName;
    private String[] debts;

    public Consumer() {
    }

    public Consumer(Integer consumerId, String consumerName, String[] debts) {
        this.consumerId = consumerId;
        this.consumerName = consumerName;
        this.debts = debts;
    }

    public Integer getConsumerId() {
        return consumerId;
    }
    @XmlElement(name = "consumerId")
    public void setConsumerId(Integer consumerId){
        this.consumerId = consumerId;
    }

    public String getConsumerName() {
        return consumerName;
    }
    @XmlElement(name = "consumerName")
    public void setConsumerName(String consumerName){
        this.consumerName = consumerName;
    }

    public String[] getDebts(){
        return debts;
    }

    @XmlElementWrapper(name = "debts")
    @XmlElement(name = "debts")
    public void setDebts(String[] debts){
        this.debts = debts;
    }

    @Override
    public String toString() {
        return "Consumer{" + consumerId + consumerName;
    }

}
