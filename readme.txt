Идея проекта: «Система управления заказами для онлайн-магазина»,
которая будет реализовывать 15 различных паттернов проектирования в Java Spring Boot.

Описание проекта
Проект представляет собой сервис управления заказами в интернет-магазине.
В нем будут реализованы такие возможности, как обработка заказов, управление пользователями,
применение скидок, уведомления, интеграция с платежными системами и многое другое.

Используемые паттерны
_____________________________________________________________
Порождающие паттерны
---- 1. Singleton – Управление конфигурацией

Используется для хранения глобальной конфигурации приложения, например, класса SecurityConfig.

---- 2. Factory Method – Создание различных типов пользователей
(AdminUserFactory, CustomerUserFactory, GuestUserFactory)

Позволяет создавать объекты пользователей (AdminUser, CustomerUser) через фабричный метод.

----- 3. Abstract Factory – Создание пользователей и связанных платежных методов
(UserPaymentFactory)
Используется для создания семейства объектов: различных типов пользователей
 (AdminUser, CustomerUser, GuestUser)
и их платежных методов (BankTransfer, PayPal, Stripe) через единую фабрику.
Таким образом, при создании нового пользователя автоматически выбирается доступный для него способ оплаты.

                Abstract Factory
                   (UserPaymentFactory)
                           │
       ┌───────────────────┴───────────────────┐
       │                                       │
Concrete Factory (Factory Method)     Concrete Factory (Factory Method)
  (AdminUserFactory)                   (CustomerUserFactory)
       │                                       │
Создает:                                Создает:
- AdminUser                             - CustomerUser
- BankTransferPayment                   - PayPalPayment


---------- 4. Builder – Построение заказов

Применяется для пошагового создания заказа (OrderDTOBuilder).

------ 5. Prototype – Клонирование заказов

Используется для быстрого копирования заказа, если нужно создать новый заказ на основе существующего.

-
- восможность отредактировать перед созданием клона
-
_____________________________________________________________

Structural patterns

1. Adapter - PaymentProcessor

    Purpose: Allows incompatible interfaces to work together.

    Use Case: Integrate a legacy payment system (e.g., LegacyPaymentSystem)
    with your modern payment processing interface (PaymentProcessor).
    The legacy system might have a different method signature, and the Adapter will bridge this gap.

    Implementation: Create an adapter to convert calls from the modern PaymentProcessor interface
    to the legacy system's methods.

2. Decorator

    Purpose: Dynamically adds responsibilities to objects in a flexible way.

    Use Case: Enhance the discount application process.
    For example, allow stacking multiple discounts (e.g., seasonal discount, loyalty discount)
    on an order without modifying the core order class.

    Implementation: Create a DiscountDecorator to wrap the base order and apply additional discounts.

3. Facade

    Purpose: Provides a simplified interface to a complex subsystem.

    Use Case: Simplify interactions with the order processing subsystem,
    which involves multiple components like inventory, payment, and notification services.

    Implementation: Create an OrderFacade that exposes a single method to process an order,
    hiding the complexity of coordinating multiple services.

4. Composite

    Purpose: Treats individual objects and compositions of objects uniformly.

    Use Case: Manage order items hierarchically,
    where an order can contain individual items or bundles (groups of items treated as a single item).

    Implementation: Define an OrderItemComponent interface for both individual items and bundles,
    allowing uniform handling.

5. Proxy

    Purpose: Controls access to an object, adding functionality like lazy loading or access control.

    Use Case: Implement lazy loading for user profile data
    (e.g., fetching detailed user data only when needed) to optimize performance.

    Implementation: Create a UserProfileProxy that delays loading user details until requested.