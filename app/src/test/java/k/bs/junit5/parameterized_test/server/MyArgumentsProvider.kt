package k.bs.junit5.parameterized_test.server

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import java.util.stream.Stream


class MyArgumentsProvider : ArgumentsProvider {

    override fun provideArguments(context: ExtensionContext): Stream<Arguments> {
        return listOf("apple", "banana").map { Arguments.of(it) }.stream()
    }
}