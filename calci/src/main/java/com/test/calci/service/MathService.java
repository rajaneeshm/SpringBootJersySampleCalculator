package com.test.calci.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.test.calci.model.Math;

@Service("mathService")
@CacheConfig(cacheNames = {"cache"})
public class MathService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Cacheable(value="cache",key="#math.getA()+#math.getB()+#math.getC()+#math.getOperation()")
	public Math add(Math math) {
		logger.info("In Service addition :  a:"+math.getA()+" b:"+math.getB()+" c:"+math.getC());
		math.setResult(math.getA() + math.getB() + math.getC());
		return math;
	}

	@Cacheable(value="cache",key="#math.getA()+#math.getB()+#math.getC()+#math.getOperation()")
	public Math subtract(Math math) {
		logger.info("In Service subtraction :  a:"+math.getA()+" b:"+math.getB()+" c:"+math.getC());
		math.setResult(math.getA() - math.getB() - math.getC());
		return math;
	}

	@Cacheable(value="cache",key="#math.getA()+#math.getB()+#math.getC()+#math.getOperation()")
	public Math multiply(Math math) {
		logger.info("In Service multiplication :  a:"+math.getA()+" b:"+math.getB()+" c:"+math.getC());
		math.setResult(math.getA() * math.getB() * math.getC());
		return math;
	}

	@Cacheable(value="cache",key="#math.getA()+#math.getB()+#math.getOperation()")
	public Math divide(Math math) {
		logger.info("In Service division :  a:"+math.getA()+" b:"+math.getB());
		math.setResult(math.getA() / math.getB());
		return math;
	}

}
