package com.at.springframework.beans.factory.config;

import com.at.springframework.beans.factory.BeanFactory;

/**
 * Extension of the {@link com.at.springframework.beans.factory.BeanFactory}
 * interface to be implemented by bean factories that are capable of
 * autowiring, provided that they want to expose this functionality for
 * existing bean instances.
 *
 * 是一个自动化处理Bean工厂配置的接口，目前案例工程中还没有做相应的实现，后续逐步完善
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
}
