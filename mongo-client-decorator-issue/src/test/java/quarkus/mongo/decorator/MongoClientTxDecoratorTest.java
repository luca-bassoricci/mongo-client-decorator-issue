package quarkus.mongo.decorator;

import com.mongodb.client.MongoClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
class MongoClientTxDecoratorTest
{
	@Inject
	MongoClient client;

	@org.junit.jupiter.api.Test
	void test()
	{
		var ex = assertThrows(RuntimeException.class, () -> client.listDatabaseNames());
		assertEquals(ex.getMessage(), "from " + MongoClientTxDecorator.class);
	}
}
