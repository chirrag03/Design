package coffeeMachine;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FailedFuture implements Future<Response> {

  private Response response;

  public FailedFuture(Response response) {
    this.response = response;
  }

  @Override
  public boolean cancel(boolean b) {
    return false;
  }

  @Override
  public boolean isCancelled() {
    return false;
  }

  @Override
  public boolean isDone() {
    return false;
  }

  @Override
  public Response get() throws InterruptedException, ExecutionException {
    return response;
  }

  @Override
  public Response get(long l, TimeUnit timeUnit)
      throws InterruptedException, ExecutionException, TimeoutException {
    return response;
  }
}
