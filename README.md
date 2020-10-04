# task-manager
To startup zookeeper+kafka :
docker-compose up -d

zookeeper on port 2181
kafka on port 9092

Each task request will be put in separate  topic with name: task-generation-{TASK-KEY}
Prefix in properties: kafka.topic.task.generation

Task completion should be put in topic: task-generation-completed
This topic is listened by "task-generation-completed-group" consumer group.


Request new task generation 
POST http://localhost:8080/task/generation
Content-Type: application/json

{
  "key" : "dummy-report"
}

Add new Task
PUT http://localhost:8080/task
Content-Type: application/json

{
  "key": "test-report",
  "taskName": "Test Report"
}

Administration:
GET http://localhost:8080/admin/topic
GET http://localhost:8080/admin/groups

To get more info kafka console tools should be used.