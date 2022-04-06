package pageResources;

public enum LoginResources {

    LoginButton("//span[text()='Login']/parent::button"),
    InputMail("//input[@placeholder='Email']"),
    InputPassword("//input[@placeholder='Password']"),
    HomeButton("//a[normalize-space()='Home']");

    private final String resource;

    LoginResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
