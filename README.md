# Read Me First

The project aims to store some common 'text'/document for your application. It provides a series of APIs.

You can put your privacy policy, accessibility statement and eula etc. by integrating with this project.

The project only support text under length 2KB.

## How to use this project

### Preconditions

Your application project is using Java(>8) and Gradle

### APIs

#### Query by type

```Get /api/common-document-storage/common-document/type/{type}```
``` Response 
[
  {
    "id": 1,
    "type": "PRIVACY_POLICY",
    "sequence": 1,
    "content": "xxx",
    "createTime": Instant,
    "updateTime": Instant
  },
  {
    "id": 2,
    "type": "PRIVACY_POLICY",
    "sequence": 2
    "content": "xxxx",
    "createTime": Instant,
    "updateTime": Instant
  }
]
```

### Integration Steps

#### Create the table and insert initial data

* If you are using Linquibase to control your database version, add the file ```20220729095216_added_entity_CommonDocument.xml``` to your change logs
  Uncomment the changeset ```20220729095216-1-data```, make sure you have the initial data file ```config/liquibase/fake-data/common_document.csv```
* Otherwise, create the table based on the entity declaration ```CommonDocument```, And insert the data as the way you like

#### Add the repository as a submodule of your application repository

```
git commit -am 'commit all your changes first'
git subtree add --prefix=you-application-dir/your-backend-dir/common-document-storage https://github.com/UoM-Digital-Health-Software/common-document-storage.git main --squash
```
Update your application repository with the submodules

```
git submodule update --init --recursive
```

Update submodules

```
git subtree pull --prefix you-application-dir/your-backend-dir/common-document-storage https://github.com/UoM-Digital-Health-Software/common-document-storage.git main --squash
```

### Configure your application project to include the project

Add ```include 'common-document-storage'``` in the ```settings.gradle```

### Enable the api

Add ```common-document-storage.enable=true``` to your application.yaml/properties
