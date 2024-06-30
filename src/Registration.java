public interface Registration {
    public void register(String user, String pass , String mobile,int balance);
    public String verify();
    public String generateRandomString(int length);
    public String checkUniqueBankUser(String username);
}
