package quarkus.mongo.decorator;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoIterable;

import io.quarkus.logging.Log;
import jakarta.annotation.Priority;
import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Any;
import jakarta.inject.Inject;

@Dependent
@Decorator
@Priority(1)
public abstract class MongoClientTxDecorator implements MongoClient
{
	@Inject
	@Delegate
	@Any
	MongoClient delegate;

	@Override
	public MongoIterable<String> listDatabaseNames()
	{
		Log.infof("%s:listDatabaseNames()", MongoClientTxDecorator.class.getSimpleName());
		throw new RuntimeException("from " + MongoClientTxDecorator.class);
	}
}
