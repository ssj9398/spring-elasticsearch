# spring-elasticsearch

## 엘라스틱 서치란?
1. Apache Lucene 기반의 Java 오픈소스 분산형 RESTful 검색 및 분석엔진
2. 방대한 양의 데이터에 대해 실시간으로 저장과 검색 및 분석을 수행 할 수 있다.
3. Mysql과 다르게 이런게 가능한 이유는 엘라스틱서치는 JSON 문서로 데이터를 저장하기 때문 
4. 역색인이라는 자료구조 사용 (빠른 성능 보장)


### 설치
----
- 호환성 체크 https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/#new-features
1. 도커로 elasticsearch 이미지 받아서 실행
```docker
$ docker pull docker.elastic.co/elasticsearch/elasticsearch:7.10.0
```

```docker
$ docker run -d -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.10.0
```


- http://localhost:9200 포트로 엘라스틱 서치가 정상적으로 설치 되었는지 테스트

build.gradle 의존성 추가
- implementation 'org.springframework.data:spring-data-elasticsearch:4.2.2'

### 마주한 에러들
The bean 'userRepository', defined in com.example.elasticsearch.user.domain.UserRepository defined in @EnableJpaRepositories declared on JpaRepositoriesRegistrar.EnableJpaRepositoriesConfiguration, could not be registered.
A bean with that name has already been defined in com.example.elasticsearch.user.domain.UserRepository defined in @EnableElasticsearchRepositories declared on ElasticsearchRepositoriesRegistrar.EnableElasticsearchRepositoriesConfiguration and overriding is disabled.

Action:
Consider renaming one of the beans or enabling overriding by setting spring.main.allow-bean-definition-overriding=true

### 해결
not all primary shards of [.geoip_databases] index are active
엘라스틱서치 설정을 수정해줘야 했다


