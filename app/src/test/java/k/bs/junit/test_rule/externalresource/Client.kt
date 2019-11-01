package k.bs.junit.test_rule.externalresource

class Client(val userId: Int) {

    fun run(server: Server) {
        server.addUser(this)
    }
}