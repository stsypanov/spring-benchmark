package org.tsypanov.sb.aspect.service;

import java.util.concurrent.ThreadLocalRandom;

public class AspectedServiceImpl implements AspectedService {
  private final ThreadLocalRandom random = ThreadLocalRandom.current();

  @Override
  public long getRandomLongWithAspect() {
    return random.nextLong();
  }

}
