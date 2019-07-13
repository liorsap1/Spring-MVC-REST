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

Use postman to get, put and post.

Get example:
GET http://my-service/api/network?id=2

Put example:
PUT http://my-service/api/network/connect
		{
			"device_id": "lior_device_123",
			"network_id": "3",
			"auth" : "public"
		}
       
Post example:
POST http://my-service/api/network/report
		{
			"device_id": "Samasung_device_a1b2",
			"network_id": "5",
			"throughput" : 600
		}

