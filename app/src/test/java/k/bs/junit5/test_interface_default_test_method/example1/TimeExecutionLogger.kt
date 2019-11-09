package k.bs.junit5.test_interface_default_test_method.example1

import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.extension.ExtendWith

@Tag("timed")
@ExtendWith(TimingExtension::class)
interface TimeExecutionLogger