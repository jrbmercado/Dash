public class Payment {
    private String cardName;
    private String cardNum;
    private String expDate;
    private String ccv;

    public Payment(String cardName, String cardNum, String expDate, String ccv) {
        setCardName(cardName);
        setCardNum(cardNum);
        setExpDate(expDate);
        setCcv(ccv);
    }

    public boolean validCardNumber(String input) { // Convert string to an array of ints
        int[] creditCardInts = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            creditCardInts[i] = Integer.parseInt(input.substring(i, i + 1));
        }

        if (creditCardInts.length == 16 || creditCardInts.length == 15) {
            return true;
        }
        return false;
    }

    public String getCardName() {
        return this.cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNum() {
        return this.cardNum;
    }

    public void setCardNum(String cardNum) {
        if (validCardNumber(cardNum)) {
            this.cardNum = cardNum;
        } else {
            this.cardNum = "";
        }
    }

    public String getExpDate() {
        return this.expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getCcv() {
        return this.ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public String getInfo() {
        String x = "Card Name: " + this.cardName + "\nCard Number: " + this.cardNum + "\nExp Date:" + this.expDate
                + "\nCCV:" + this.ccv;
        return x;
    }
}
