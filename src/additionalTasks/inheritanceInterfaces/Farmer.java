package additionalTasks.inheritanceInterfaces;
/*Фермер живет за счет ресурсов, собираемых с животных. Изначально фермер создается с 5 единицами ресурсов.
Фермер должен иметь возможность:
1. собрать ресурсы с домашних животных, которые могут давать ресурсы
2. съесть домашнее животное, которое пригодно в пищу (когда на ферме не останется животных, которые дают ресурсы). При этом расчет ресурсов следующий: 1кг животного -  1 единица ресурса
3. прогнать дикое животное, которое пришло на ферму
4. кормить домашнее животное*/
public class Farmer {
    int resources = 5;
    Pet[] pets = new Pet[10];



    public void checkForResources(){
        for (int i = 0; i < pets.length; i++) {
            if (!pets[i].isDead() && pets[i].resources != 0){
                this.resources += pets[i].resources;
            }
        }
    }
    
    public void eatPet(){

    }

    public void getAnimals (){
        for (int i = 0; i < pets.length; i++) {
            pets[i] = Pet.getPet();
        }
    }



}
