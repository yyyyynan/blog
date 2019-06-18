package com.yitu2.demo.redis;

import org.springframework.stereotype.Service;

/**
 * Date:2018/6/25
 * @author ZhuShangJin
 */
@Service
public class PersonService {

    /**
     * 这个方法里的东西只能作为缓存的参考
     * 关于缓存这一块可以在controller层进行调用
     * 关于缓存
     * 这个功能倒是集成进来了 但是缓存的更新这一块有很大的问题
     * 可能是我太菜了8 慢慢来慢慢来
     * 平常开发的时候缓存功能会禁止掉
     *
     * 然后 缓存的使用方式
     * 就是下面这几个被注释掉的函数了
     * 大致流程就是在controller层调用cacheable函数 然后减少访问数据库的次数
     * 需要注意的是 记录的数据应当是流动性不大 数量相对较小且稳定的
     *
     */

//    @Autowired
//    private PersonRepo personRepo;
//
//    /**
//     * @Cacheable 应用到读取数据的方法上，先从缓存中读取，如果没有再从DB获取数据，然后把数据添加到缓存中
//     * unless 表示条件表达式成立的话不放入缓存
//     * @param username
//     * @return
//     */
//    @Cacheable(value = "user", key = "#root.targetClass + #username", unless = "#result eq null")
//    public Person getPersonByName(String username) {
//        Person person = personRepo.getPersonByName(username);
//        return person;
//    }
//
//    /**
//     * @CachePut 应用到写数据的方法上，如新增/修改方法，调用方法时会自动把相应的数据放入缓存
//     * @param person
//     * @return
//     */
//    @CachePut(value = "user", key = "#root.targetClass + #result.username", unless = "#person eq null")
//    public Person savePerson(Person person) {
//        return personRepo.savePerson(person);
//    }
//
//    /**
//     * @CacheEvict 应用到删除数据的方法上，调用方法时会从缓存中删除对应key的数据
//     * @param username
//     * @return
//     */
//    @CacheEvict(value = "user", key = "#root.targetClass + #username", condition = "#result eq true")
//    public boolean removePersonByName(String username) {
//        return personRepo.removePersonByName(username) > 0;
//    }
//
//    public boolean isExistPersonName(Person person) {
//        return personRepo.existPersonName(person) > 0;
//    }
}