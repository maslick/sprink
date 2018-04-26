//package io.maslick.sprink;
//
//import org.springframework.context.support.AbstractApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.util.List;
//
//class Performer {
//
//    private List<Instrument> instruments;
//
//    public List<Instrument> getInstruments() {
//        return instruments;
//    }
//
//    public void setInstruments(List<Instrument> instruments) {
//        this.instruments = instruments;
//    }
//
//    @Override
//    public String toString() {
//        return "Performer [instruments=" + instruments + "]";
//    }
//}
//
//
//class Instrument {
//
//    private String name;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "Instrument [name=" + name + "]";
//    }
//}
//
//class AppMain {
//    public static void main(String args[]){
//        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        System.out.println("number of beans: " + context.getBeanDefinitionCount());
//        System.out.println();
//
//        Performer performer = context.getBean("performer", Performer.class);
//        performer.getInstruments().forEach(System.out::println);
//    }
//}