public class Paragraphs {
    public String numberTU;
    public String numberTP;
    public String function;
    public String function2;
    public String subscriber;
    public String address;
    public String point;

    public Paragraphs() {

    }

    public Paragraphs(String numberTU, String function, String subscriber, String address, String point) {
        this.numberTU = numberTU;
        this.function = function;
        this.subscriber = subscriber;
        this.address = address;
        this.point = point;
    }

    public String getNumberTU() {
        return numberTU;
    }

    public void setNumberTU(String numberTU) {
        this.numberTU = numberTU;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Paragraphs{" +
                "numberTU='" + numberTU + '\'' +
                ", numberTP='" + numberTP + '\'' +
                ", function='" + function + '\'' +
                ", subscriber='" + subscriber + '\'' +
                ", address='" + address + '\'' +
                ", point='" + point + '\'' +
                '}';
    }
}
