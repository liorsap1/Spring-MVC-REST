How to run the application:

Download the source code.
Open in IntelliJ or other editor, build and run the project.

In the Wiki page there is an instructions how to send the requests properly.

I put some initial data in bootstrap:

[
    {
        "id": 1,
        "auth": "wpa",
        "avg_throughput": 0,
        "devices": null
    },
    {
        "id": 2,
        "auth": "public",
        "avg_throughput": 0,
        "devices": null
    },
    {
        "id": 3,
        "auth": "wpa",
        "avg_throughput": 0,
        "devices": null
    },
    {
        "id": 4,
        "auth": "public",
        "avg_throughput": 0,
        "devices": null
    }
]

Use postman to requests: get, put and post.
The response will be type json.

Get example: (localhost:8080 can be replace with your own machine)
GET http://localhost:8080/my-service/api/network?id=2

Put example: (localhost:8080 can be replace with your own machine)
PUT http://localhost:8080/my-service/api/network/connect
		{
			"device_id": "lior_device_123",
			"network_id": "3",
			"auth" : "public"
		}
       
Post example: (localhost:8080 can replace with be your own machine)
POST http://localhost:8080/my-service/api/network/report
		{
			"device_id": "Samasung_device_a1b2",
			"network_id": "5",
			"throughput" : 600
		}

