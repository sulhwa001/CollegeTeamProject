//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.eat();
        Animal c = new Animal();
        c.eat();
        Animal d = new Cat();

        d.eat();
//        Dog b = new Animal();
        }
    }

class Animal {
    void eat(){
        System.out.println("Animal is eating.");
    }
}

class Dog extends Animal {
    void eat() {
        System.out.println("Dog is eating.");
    }
}

class Cat extends Animal {
    void eat() {
        System.out.println("Cat is eating.");
    }
}


