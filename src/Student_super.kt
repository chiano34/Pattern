import com.fasterxml.jackson.annotation.JsonProperty
open class Student_super {
    @field:JsonProperty("id") var id: Int=0
        get(){
            return field
        }
        set(value){
            if(value>0)
                field=value
        }
    companion object{
        var counter=0
        val phoneReg = Regex("^\\+7\\d{10}\$|^8\\d{10}\$")
        val fioReg=Regex("^[A-ZА-ЯЁ][a-zа-яё]{1,}$")
        val mailReg=Regex("""\w*\@\w*\.\w*""")
        val telegramReg=Regex("^@+[a-zA-Z0-9_]{5,64}$")
        val gitReg=Regex("^[a-zA-Z0-9]+/[a-zA-Z0-9-_]+\$")
        fun checkGit(value: String?):Boolean{
            if(gitReg.matches(value.toString()))
                return true
            else
                return false
        }

        fun checkTg(value: String?):Boolean{
            if(telegramReg.matches(value.toString()))
                return true
            else
                return false
        }
        fun checkEmail(value: String?):Boolean{
            if(mailReg.matches(value.toString()))
                return true
            else
                return false
        }
        fun checkFio(value: String?):Boolean{
            if(fioReg.matches(value.toString()))
                return true
            else
                return false
        }
        fun checkPhone(value: String?):Boolean{
            if(phoneReg.matches(value.toString()))
                return true
            else
                return false
        }
    }
    init {
        counter++
    }
}