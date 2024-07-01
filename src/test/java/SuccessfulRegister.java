public class SuccessfulRegister {
    private Integer id;
    private String token;

    public SuccessfulRegister(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}
