package k.bs.junit.test_rule.externalresource

class Server {

    val activeUser = mutableListOf<Client>()

    fun connect() {
        println("Server Connected")
    }

    fun disconnect() {
        println("Server Disconnected")
    }

    fun addUser(user: Client) {
        activeUser.add(user)
    }

    fun removeUser(user: Client) {
        activeUser.remove(user)
    }


}