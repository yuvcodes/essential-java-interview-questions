## What will happen if you put the return statement or System.exit () on the try or catch block? Will finally block execute?

#### This is a very popular tricky Java question, and it's tricky because many programmers think that no matter what, but the finally block will always execute. This question challenge that concept by putting a return statement in the try or catch block or calling System.exit() from try or catch block.


#### The answer to this tricky question in Java is that finally, the block will execute even if you put a return statement in the try block or catch block but finally block won't run if you call System.exit() from the try or catch block.