package k.bs.junit5.conditional_test_excution.system_property

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable


class SystemPropertyTests {
    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
    fun onlyOnStagingServer() {
        // ...
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
    fun notOnDeveloperWorkstation() {
        // ...
    }
}