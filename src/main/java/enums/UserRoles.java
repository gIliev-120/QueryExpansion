package enums;

/**
 * Created by giliev on 11.1.2019 г..
 */
public enum UserRoles {
    ADMINISTRATOR(1),
    USER(2);
    int id;
    UserRoles(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }}
