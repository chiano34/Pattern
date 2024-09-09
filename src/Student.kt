class Student(
    private val id: Int,
    private var lastName: String,
    private var firstName: String,
    private var surname: String,
    private var phone: String? = null,
    private var telegram: String? = null,
    private var email: String? = null,
    private var git: String? =null

) {
    var LastName: String
        get() = lastName
        set(value){
            lastName=value
        }
    var FirstName: String
        get() = firstName
        set(value){
            firstName=value
        }
    var Surname: String
        get() = surname
        set(value){
            surname=value
        }
    var Phone: String
        get() {
            if (phone != null)
                return phone as String
            else
                return "Phone number not found"
        }
        set(value){
            phone=value
        }
    var Telegram: String
        get() {
            if (telegram != null)
                return telegram as String
            else
                return "telegram number not found"
        }
        set(value){
            telegram=value
        }
    var Email: String
        get() {
            if (email != null)
                return email as String
            else
                return "email number not found"
        }
        set(value){
            email=value
        }
    var GitHub: String
        get() {
            if (git != null)
                return git as String
            else
                return "git number not found"
        }
        set(value){
            git=value
        }
    fun printObj()
    {
        print("ID: $id, Фамилия: $lastName, Имя: $firstName, Отчество: $surname")
        if(phone!=null)
            print(", Телефон: $phone")
        if(telegram!=null)
            print(", Телеграм: $telegram")
        if(email!=null)
            print(", Почта: $email")
        if(git!=null)
            print(", Git: $git")
        println()
    }


}