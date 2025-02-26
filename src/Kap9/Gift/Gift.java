package Kap9.Gift;

public class Gift {

    private String giftNumber;
    private String giftName;

    public Gift(String giftName, String giftNumber){

        this.giftName = giftName;
        this.giftNumber = giftNumber;

    }

    public Gift() {

    }


    public String setGiftNumber(String giftNumber) throws GiftNumberInvalidException {

            Integer.parseInt(giftNumber);
            if(giftNumber.length() < 10){
                throw new GiftNumberInvalidException();
            }

        return giftNumber;
    }

    public String setGiftName(String giftName) throws GiftNameInvalidException {

        if(giftName.isEmpty()) {
            throw new GiftNameInvalidException();
        }

        return giftName;
    }
}
