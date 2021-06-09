# drools-springboot

drools规则引擎与spring的结合，依赖于kie-spring，做一个简单的整合，将调用业务、处理业务、规则源分离。

规则引擎的五个构成部分，它在 drools 上分别对应：

- 规则 -> rule，对应一个规则
- 触发器 -> 对应 kieSession 的上下文
- 条件 -> 对应规则的 LHS，也就是上文的 `when`，在里面包含n个条件（pattern），并且是以条件是否满足为判断
- 作用 -> 对应规则的 RHS，也就是上文的 `then`，一般是使用函数调用，结合 `fact`（规则对象），来达成目的

下面是简单的调用例子：

``` java
KieSession kieSession = kieContainer.newKieSession();
kieSession.insert(p);
kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("person"));
kieSession.dispose();
```

## 目录说明

- constants: 存放一些预设的常量
- drools: drools关键配置及相关bean
- pojo:
    - executeparam: 执行规则传输的参数封装
    - fact: 规则对象实体
- service:
    - share: 示例中业务包，这里是用分享业务作为例子