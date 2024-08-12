# Жадные алгоритмы

Жадные алгоритмы, как правило, решают оптимизационные задачи и на каждом шаге делают некоторый
наиболее очевидный шаг, так называемый жадный шаг, таким образом строят оптимальное решение.

## Easy

### Пример. Покрытие точек отрезками.

Есть множество n точек на прямой. Необходимо покрыть все точки
минимальным количеством отрезков единичной длины.    
Надежный шаг - это добавить отрезок, левый конец которого совпадает с самой крайней левой точкой.
Мы заранее знаем, что это оптимальный шаг. Так как есть множество оптимальных решений, то мы
выбираем одно из них, которе описано в надежном шаге.    
Решение - выполнять надежный шаг на каждой итерации цикла, при этом забывая те точки которые
покрыли отрезком.
Сложность O(n^2)

### Пример. Необходимо взять максимальное количество вершин не соединенных ребром.

Надежный шаг - существует оптимальное решение, которое содержит все листья дерева, то есть все
вершины, у которых нет, дочерних вершин.

### Пример. Задача о непрерывном рюкзаке

Есть веса w1...wn и стоимости предметов c1...cn. А так же вместимость рюкзака W. Необходимо
узнать суммарную стоимость ЧАСТЕЙ всех предметов в рюкзаке, вес которых не превышает W. То есть
можно предмет разделить на часть, при этом стоимость и вес его пропорционально изменятся.    
Надежный шаг - существует оптимальное решение, содержащее максимально возможную часть предмета,
**стоимость которого за килограмм максимальна**. То есть надо использовать по максимома самый
дорогой предмет.

## Коды Хаффмана

Оптимальный бинарный код для сжатия строки.

### Пример.

На вход подается строка и мы хотим каждому ее символу присвоить бинарный код так, что бы после
того как каждый символ заменили на его бинарный код получилась как можно более короткая бинарная
строчка. Оптимизация - попытаться часто используемому символу присвоить более короткий код.
Свойство - код называется **беспрефиксными**, если никакой код символа не является префиксом другого
кода символа. Это значит, что ни один код символа не является префиксом кода другого символа,
таким образом когда мы будем читать коды мы всега однозначно будем понимать, что это за символ.
Беспрефиксными коды удобно представлять в двоичном дереве.    
Частота некорневой вершины назовем количество раз, которое вершина будет посещена в процессе
кодировки\декодировки. Таким оразом мы ищем строго двоичное дерево с минимальной суммой пометок
в вершинах, в котором листья помечены входными частотами, а внутренние вершины - суммами
пометок их детей. Две минимальные частоты будут листьями на самом нижнем уровне и можно считать,
что они братья. Надежный шаг - выбрать две минимальные частоты fi и fj, сделать их детьми новой
вершины с пометкой fi+fj; выкинуть частоты fi и fj, добавить fi + fj.

## Очереди с приоритетами

Очереди обладают методами:

1) Добавление элемента в очередь
2) Извлечение элемента с минимальным приоритетом
3) Извлечение элемента на который указывает итератором

Наивная реализация очередей с приоритетами - через массив.

1) Неупорядоченный массив. Доступ к элементу O(n)
2) Упорядоченный массив. Доступ к элементу с минимальным приоритетом за O(1), но удаление
   элемента по индексу приведет к сдвигу в массиве, и может быть время O(n)
3) Упорядоченный связанный список. Доступ к минимальному элементу за O(1), удаление O(1), но
   добавление элемента за O(n)

Правильная реализация - куча.
Куча - это двоичное дерево. Свойства кучи:

1) Значение вершины <= значений ее детей
2) Минимальное значение хранится в корне дерева. поэтому получение минимального значение
   выполняется за O(n). В таком случае куча называется MIN куча.
   Для MAX кучи свойства звучат наоборот MIN куче.

Операции на деревом:

1) Добавление нового элемента. Добавление элемента - подвешиваем его листом в какую-нибудь
   вершину. Таким образом нарушается свойство 1) кучи. Поэтому надо просеить кучу, то есть
   починить дерево.

**Просеивание кучи вверх:**    
Дальше поменяем ноду с новым элементом на ее родительскую ноду, проверяем,
что дерево починилось, если нет, то повторяем просеивание - меняем местами новую новую ноду и
родительскую.

**Время работы операции вставки:**

- В каждый момент времени свойство кучи нарушено не более чем в одной вершине.
- При просеивании вверх вершина становится ближе к корню
- Время работы O(h), где h - это высота кучи

2) Извлечение минимума. Мы извлекаем корень дерева, но на его место надо кого-нибудь поставить
   на корень. Свойство кучи может нарушиться, то есть корень может быть больше чем его дети. Для
   починки надо просеить кучу вниз.

**Просеивание кучи вниз:**    
Можем менять проблемную вершину с одним из ее детей. Надо выбрать только того ребенка, который  
меньше другого. Таким образом мы знаем, что чинить дерево придется только в одной из его
поддеревьев. Время работы O(h)

3) Изменение приоритета. при изменении приоритета элемента мы проверяем, если новый приоритет
   меньше, чем был раньше, то надо просеивать вверх, если больше чем был, то надо просеивать вниз
4) Удаление. Для удаления надо изменить приоритет элемента на минус бесконечность или на ту
   которой гарантированно нет в нашей куче, просеить элемент наверх, то есть в корень и дальше
   извлечь минимум. Дальнейшие действия определяются свойствами извлечения минимума.

**Полные двоичные деревья**    
Это такие деревья у которого заполнены все уровни, кроме может быть последнего. Последний
уровень заполнен слева направо, но может быть не до конца. Мы представляем,
что заполняем дерево так: сначала корень, потом следующий уровень слева направо и дальше. Таком
образом дерево может быть представлено в виде массива.     
Свойство - если у вершины индекс i, то у ее детей будут индексы слева направо 2i и 2i+1, а ее
родитель будет иметь индекс i/2 формально округленный. То есть если i = 5, то дети имеют индексы
10 и 11, а родитель 2.

Резюмируя:

1) деревья у которого заполнены все уровни, кроме может быть последнего. Последний
   уровень заполнен слева направо, но может быть не до конца.
2) Естественная нумерация вершин сверху вниз и слева направо.
3) При добавлении элемента подвешиваем лист на последний уровень. А при удалении отрезаем самый
   последний лист.
4) Индексы - если у вершины индекс i, то у ее детей будут индексы слева направо 2i и 2i+1, а ее
   родитель будет иметь индекс i/2 формально округленный. При вычислении данных индексов надо
   проверять, что они попадают в отрезок [1,n], где n - размер кучи.
5) Не нужно хранить указатели на родителей и детей
6) Глубина кучи есть O(log n), что означает, что все операции над кучей будут выполняться за
   время O(log n)