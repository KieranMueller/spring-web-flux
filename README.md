# async branch
- Here, we are using Flux to create a non-blocking endpoint
- Steps
    - Clone and start the project
    - Head to localhost:8081/stocks/blocking, you'll notice the data 
takes 5 seconds to reach you (mocking a large request that takes a long time), watch the logs in the application to see real time info about the request
    - Head to localhost:8081/stocks/async, you'll see the data is emitted to you every second, you
are not lefting waiting for 5 seconds to receive the completed request, check the logs
