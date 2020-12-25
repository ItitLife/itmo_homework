package exams.thirdFox.stategy;

import java.util.HashMap;

public class StoryBuilder {

    public static HashMap<String, Situation> getStory() {
        HashMap<String, Situation> story = new HashMap<>();

        Situation first = new Situation(
                "///",
                "Каждое утро Лисёнок просыпался, завтракал и шёл увидеться с Бельчонком. Это утро не было исключением. " +
                        "Лисёнок пришёл на их обычное место встречи, но Бельчонка там не было. " +
                        "Лисёнок ждал, ждал, но так и не смог дождаться своего друга. " +
                        "\"Бельчонок не пропустил еще ни одной встречи, вдруг он попал в беду.\" - подумал Лисёнок. Как поступить Лисенку?",
                new String[]{"Вернуться домой", "Отправиться на поиски"}

        );
        Situation second = new Situation(
                "Вернуться домой",
                "Вернувшись домой, Лисёнок нашёл там Бельчонка. Оказалось, что Бельчонок пришёл на место встречи раньше и " +
                        "увидел там рой злобных пчел. Он поспешил предупредить об этом Лисёнка, но они разминулись. " +
                        "Наконец-то друзья нашли друг друга! Игра завершилась успехом"
        );
        Situation third = new Situation(
                "Отправиться на поиски",
                "Все лесные жители были заняты своими делами и не обращали внимания на Лисёнка и его проблему. " +
                        "Но вдруг кто нибудь видел Бельчонка... Лисёнок не знал, что ему делать. Помогите ему.",
                new String[]{"Попытаться разузнать о Бельчонке у лесных жителей", "Искать Бельчонка в одиночку"}
        );
        Situation forth = new Situation(
                "Попытаться разузнать о Бельчонке у лесных жителей",
                "Пока Лисёнок принимал решение, лесные жители разошлись кто куда. Остались только Сова и Волк. " +
                        "Но у Совы бывают проблемы с памятью, а Волк может сильно разозлиться из-за расспросов. Кого выбрать?",
                new String[]{"Расспросить Сову", "Расспросить Волка"}
        );
        Situation fifth = new Situation(
                "Искать Бельчонка в одиночку",
                "Лисёнок слишком долго плутал по лесу в поисках друга и сам не заметил, как заблудился. Теперь " +
                        "его самого нужно искать. Игра завершилась неудачей");
        Situation sixth = new Situation(
                "Расспросить Сову",
                "Сова долго не хотела говорить, но в итоге сказала, что видела испуганного Бельчонка, бежавшего " +
                        "в глубь леса. Все лесные жители знают, что в глубине леса опасно, если Бельчонок там, ему срочно нужна помощь.",
                new String[]{"Поверить Сове и отправиться в глубь леса", "Сове не стоит верить->Искать Бельчонка в одиночку"}
        );

        Situation seventh = new Situation(
                "Расспросить Волка",
                "Волк оказался вполне дружелюбным, но помочь не смог. Лишь сказал, что маленькому лисенку " +
                        "не стоит бродить по лесу одному. И как теперь поступить?\n" ,
                new String[]{"Волк прав->Вернуться домой", "Искать Бельчонка в одиночку"}
        );

        Situation eighth = new Situation(
                "Поверить Сове и отправиться в глубь леса",
                "В глубине леса Лисёнок встретил Медвежонка. Ленивый Медвежонок был готов рассказать все, " +
                        "что знает, если Лисёнок принесёт ему мёда. \n",
                new String[]{"Нет, потрачено слишком много времени, нужно идти дальше->Искать Бельчонка в одиночку",
                        "Нужно воспользоваться шансом и раздобыть мёд"}
        );
        Situation ninth = new Situation(
                "Нужно воспользоваться шансом и раздобыть мёд",
                "Лисёнок быстро нашёл мёд, но вокруг летал рой злобных пчел. Лисёнок всегда боялся пчёл, но " +
                        "и не найти друга он тоже боялся.\n",
                new String[]{"Подождать, вдруг пчёлы улетят", "Нужно попытаться выкрасть мёд немедленно"}
        );
        Situation tenth = new Situation(
                "Подождать, вдруг пчёлы улетят",
                "Лисёнок подождал немного, и пчёлы разлетелись. Лисёнок без проблем набрал мёда. Вдруг он" +
                        " понял, что очень голоден. Что же делать?\n",
                new String[]{"Поесть немного и передохнуть", "Скорее отнести мёд Медвежонку"}
        );
        Situation eleventh = new Situation(
                "Нужно попытаться выкрасть мёд немедленно",
                "Это была не лучшая идея. Пчёлы покусали Лисёнка, теперь ему самому нужна помощь. Игра закончилась неудачей"
                );
        Situation twelfth = new Situation(
                "Поесть немного и передохнуть",
                "Пока Лисёнок ел, злобные пчёлы вернулись и покусали его. Лисёнку нужна помощь, он не " +
                        "сможет продолжить поиски. Игра завершилась неудачей"
        );
        Situation thirteenth = new Situation(
                "Скорее отнести мёд Медвежонку",
                "Довольный Медвежонок рассказал Лисёнку, что очень хорошо знает семью Белок и уверен, что " +
                        "Бельчонок никогда не пошёл бы в глубь леса. Он заверял Лисёнка, что Белки не попадают в " +
                        "неприятности, и что Совам нельзя верить, он также уговаривал Лисёнка вернуться домой.",
                new String[]{"Межвежонок ничего не знает, нужно продолжить поиски->Искать Бельчонка в одиночку",
                        "Может быть он прав и Лисёнок просто паникует->Вернуться домой"}
        );

        story.put(first.getTitle(), first);
        story.put(second.getTitle(), second);
        story.put(third.getTitle(), third);
        story.put(forth.getTitle(), forth);
        story.put(fifth.getTitle(), fifth);
        story.put(sixth.getTitle(), sixth);
        story.put(seventh.getTitle(), seventh);
        story.put(eighth.getTitle(), eighth);
        story.put(ninth.getTitle(), ninth);
        story.put(tenth.getTitle(), tenth);
        story.put(eleventh.getTitle(), eleventh);
        story.put(twelfth.getTitle(), twelfth);
        story.put(thirteenth.getTitle(), thirteenth);
        return story;
    }

}
