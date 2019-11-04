package com.example.localstackspringboot;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LocalStackSpringBootApplicationTests {

  @Autowired
  private AmazonS3 amazonS3;

  @Autowired
  private AmazonSQSAsync amazonSQSAsync;

  @Test
  void testS3() {
    Bucket bucket = amazonS3.createBucket("bucket");
    Assertions.assertNotNull(bucket);
    amazonS3.deleteBucket(bucket.getName());
  }

  @Test
  void testSqs() {
    CreateQueueResult createQueueResult = amazonSQSAsync.createQueue("queue");
    Assertions.assertNotNull(createQueueResult);
    amazonSQSAsync.deleteQueue(createQueueResult.getQueueUrl());
  }

}
