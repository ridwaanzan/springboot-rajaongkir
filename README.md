Deploy to docker-desktop:
```
~ you should build the jar first. use this command:
mvn install -f pom.xml

~ you can build the image using this command:
docker build -t <image-name>
```

REQUEST:
``` 
    {
        "origin": "501",
        "destination": "114",
        "weight": 1700,
        "courier": "jne"
    }
```
RESPONSE:
``` 
    [
        {
            "code": "jne",
            "name": "Jalur Nugraha Ekakurir (JNE)",
            "costs": [
                {
                    "service": "OKE",
                    "description": "Ongkos Kirim Ekonomis",
                    "cost": [
                        {
                            "value": 54000,
                            "etd": "4-5",
                            "note": ""
                        }
                    ]
                },
                {
                    "service": "REG",
                    "description": "Layanan Reguler",
                    "cost": [
                        {
                            "value": 62000,
                            "etd": "2-3",
                            "note": ""
                        }
                    ]
                }
            ]
        }
    ]
```