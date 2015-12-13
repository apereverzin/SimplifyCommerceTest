package com.creek.simplifycommercetest;


/**
 * 
 * @author andreypereverzin
 */
public class SimplifyCommerceApp {
//    private static final String PUBLIC_KEY = "sbpb_MjI5MDEyZGMtMTU5Mi00Njg3LWI4NmItZThlNzY0NjBkMTFl";
//    private static final String PRIVATE_KEY = "/kVSeORjb/P9suA/HqDy9DMaDOwBVKSY/UcNoKBn02p5YFFQL0ODSXAOkNtXTToq";
//    
//    private AuthorizationService authorizationService;
//    private CardTokenService cardTokenService;
//    private ChargeBackService chargeBackService;
//    private CouponService couponService;
//    private CustomerService customerService;
//    private DepositService depositService;
//    private FraudCheckService fraudCheckService;
//    private InvoiceService invoiceService;
//    private InvoiceItemService invoiceItemService;
//    private PaymentService paymentService;
//    private PlanService planService;
//    private RefundService refundService;
//    private SubscriptionService subscriptionService;
//    private TaxService taxService;
//    private TransactionReviewService transactionReviewService;
//    
//    public static void main(final String[] args) {
//        final SimplifyCommerceApp app = new SimplifyCommerceApp();
//        app.init();
//        app.getAllResults();
//    }
//    
//    public void getAllResults() {
//        PaymentsApi.PUBLIC_KEY = PUBLIC_KEY;
//        PaymentsApi.PRIVATE_KEY = PRIVATE_KEY;
//
//        System.out.println("============\nCard Token Service\n============");
//        try {
//            final CardToken cardTokenCreated = createCardToken();
//            final CardToken cardTokenFound = findCardToken((String)cardTokenCreated.get("id"));
//        } catch (final SimplifyCommerceException ex) {
//            ex.printStackTrace();
//        }
//
//        System.out.println("============\nAuthorization Token Service\n============");
//        try {
//            final Authorization authorizationCreated = createAuthorization();
//            final Authorization authorizationFound = findAuthorization((String)authorizationCreated.get("id"));
//            final List<Authorization> authorizations = listAuthorizations();
//        } catch (final SimplifyCommerceException ex) {
//            ex.printStackTrace();
//        }
//
//        System.out.println("============\nChargeback Service\n============");
//        try {
//            final List<Chargeback> chargebacks = listChagebacks();
//        } catch (final SimplifyCommerceException ex) {
//            ex.printStackTrace();
//        }
//
//        System.out.println("============\nCustomer Service\n============");
//        Customer customerUpdated = null;
//        try {
//            final Customer customerCreated = createCustomer();
//            listCustomers();
//            final Customer customerFound = findCustomer((String)customerCreated.get("id"));
//            final Map<String, String> props = new HashMap<>();
//            customerUpdated = updateCustomer((String)customerFound.get("id"), props);
//        } catch (final SimplifyCommerceException ex) {
//            ex.printStackTrace();
//        }
//
//        System.out.println("============\nCoupon Service\n============");
//        Coupon couponUpdated = null;
//        try {
//            final Coupon couponCreated = createCoupon();
//            listCoupons();
//            final Coupon couponFound = findCoupon((String)couponCreated.get("id"));
//            final Map<String, String> props = new HashMap<>();
//            couponUpdated = updateCoupon((String)couponFound.get("id"), props);
//        } catch (final SimplifyCommerceException ex) {
//            ex.printStackTrace();
//        }
//
//        System.out.println("============\nPlan Service\n============");
//        Plan planUpdated = null;
//        try {
//            final Plan planCreated = createPlan();
//            listPlans();
//            final Plan planFound = findPlan((String)planCreated.get("id"));
//            final Map<String, String> planProps = new HashMap<>();
//            planUpdated = updatePlan((String)planFound.get("id"), planProps);
//        } catch (final SimplifyCommerceException ex) {
//            ex.printStackTrace();
//        }
//
//        System.out.println("============\nSubscription Service\n============");
//        Subscription customSubscriptionUpdated = null;
//        Subscription subscriptionWithPlanUpdated = null;
//        final Subscription subscriptionWithPlanAndCouponUpdated = null;
//        try {
//            final Subscription customSubscriptionCreated = createCustomSubscription((String) customerUpdated.get("id"));
//            final Subscription subscriptionWithPlanCreated = createSubscriptionWithPlan((String) customerUpdated.get("id"), (String) planUpdated.get("id"));
////            final Subscription subscriptionWithPlanAndCouponCreated = createSubscriptionWithPlanAndCoupon((String) customerUpdated.get("id"), (String) planUpdated.get("id"),
////                    (String) couponUpdated.get("id"));
//            listSubscriptions();
//            final Subscription customSubscriptionFound = findSubscription((String)customSubscriptionCreated.get("id"));
//            final Subscription subscriptionWithPlanFound = findSubscription((String)subscriptionWithPlanCreated.get("id"));
////            final Subscription subscriptionWithPlanAndCouponFound = findSubscription((String)subscriptionWithPlanAndCouponCreated.get("id"));
//            final Map<String, String> subscriptionProps = new HashMap<>();
//            customSubscriptionUpdated = updateSubscription((String)customSubscriptionFound.get("id"), subscriptionProps);
//            subscriptionWithPlanUpdated = updateSubscription((String)subscriptionWithPlanFound.get("id"), subscriptionProps);
////            subscriptionWithPlanAndCouponUpdated = updateSubscription((String)subscriptionWithPlanAndCouponFound.get("id"), subscriptionProps);
//        } catch (final SimplifyCommerceException ex) {
//            ex.printStackTrace();
//        }
//        
//        System.out.println("============\nDeposit Service\n============");
//        try {
//            final List<Deposit> deposits = listDeposits();
//            if (deposits.size() > 0) {
//                final String depositId = (String)deposits.get(0).get("id");
//                final Deposit depositFound = findDeposit(depositId);
//            }
//        } catch (final SimplifyCommerceException ex) {
//            ex.printStackTrace();
//        }
//
//        System.out.println("============\nFraud Check Service\n============");
//
//        System.out.println("============\nInvoice Service\n============");
//        InvoiceItem invoiceItemUpdated = null;
//        Invoice invoiceUpdated = null;
//        try {
//            final Invoice invoiceCreated = createInvoice();
//            listInvoices();
//            final Invoice invoiceFound = findInvoice((String)invoiceCreated.get("id"));
//            final Map<String, String> invoiceProps = new HashMap<>();
//            invoiceUpdated = updateInvoice((String)invoiceFound.get("id"), invoiceProps);
//
//            System.out.println("============>>\nInvoice Item Service\n============");
//            final InvoiceItem invoiceItemCreated = createInvoiceItem((String) invoiceUpdated.get("id"));
//            final InvoiceItem invoiceItemFound = findInvoiceItem((String) invoiceItemCreated.get("id"));
//            final Map<String, String> invoiceItemProps = new HashMap<>();
//            invoiceItemUpdated = updateInvoiceItem((String) invoiceItemFound.get("id"), invoiceItemProps);
//
//            System.out.println("============>>\nPayment Service\n============");
//            final Payment paymentCreated = createPayment((String) invoiceUpdated.get("id"));
//            listPayments();
//            final Payment paymentFound = findPayment((String) paymentCreated.get("id"));
//            final Map<String, String> paymentProps = new HashMap<>();
//            final Payment paymentUpdated = updatePayment((String) paymentFound.get("id"), paymentProps);
//
//            System.out.println("============>>=>>\nRefund Service\n============");
//            final Refund refundCreated = createRefund((String) paymentUpdated.get("id"));
//            listRefunds();
//            final Refund refundFound = findRefund((String) refundCreated.get("id"));
//        } catch (final SimplifyCommerceException ex) {
//            ex.printStackTrace();
//        }
//
//        System.out.println("============\nTax Service\n============");
//        Tax taxFound = null;
//        try {
//            final Tax taxCreated = createTax();
//            listTaxes();
//            taxFound = findTax((String) taxCreated.get("id"));
//        } catch (final SimplifyCommerceException ex) {
//            ex.printStackTrace();
//        }
//
//        System.out.println("============\nTransaction Review Service\n============");
//
//        System.out.println("============\nClean up\n============");
//        try {
//            if (customerUpdated != null) {
//                final Customer customerDeleted = deleteCustomer((String)customerUpdated.get("id"));
//            }
//            listCustomers();
//            
////            if (invoiceItemUpdated != null) {
////                final InvoiceItem invoiceItemDeleted = deleteInvoiceItem((String) invoiceItemUpdated.get("id"));
////            }
//            
//            if (invoiceUpdated != null) {
//                final Invoice invoiceDeleted = deleteInvoice((String)invoiceUpdated.get("id"));
//            }
//            listInvoices();
//            
////            if (customSubscriptionUpdated != null) {
////                final Subscription customSubscriptionDeleted = deleteSubscription((String)customSubscriptionUpdated.get("id"));
////            }
////            if (subscriptionWithPlanUpdated != null) {
////                final Subscription subscriptionWithPlanDeleted = deleteSubscription((String)subscriptionWithPlanUpdated.get("id"));
////            }
//            if (subscriptionWithPlanAndCouponUpdated != null) {
//                final Subscription subscriptionWithPlanAndCouponDeleted = deleteSubscription((String)subscriptionWithPlanAndCouponUpdated.get("id"));
//            }
//            listSubscriptions();
//
//            if (couponUpdated != null) {
//                final Coupon couponDeleted = deleteCoupon((String) couponUpdated.get("id"));
//            }
//            listCoupons();
//
//            if (planUpdated != null) {
//                final Plan planDeleted = deletePlan((String)planUpdated.get("id"));
//                listPlans();
//            }
//
//            if (taxFound != null) {
//                final Tax taxDeleted = deleteTax((String)taxFound.get("id"));
//                listTaxes();
//            }
//        } catch (final SimplifyCommerceException ex) {
//            ex.printStackTrace();
//        }
//
//    }
//    
//    private void init() {
//        authorizationService = new AuthorizationService(PUBLIC_KEY, PRIVATE_KEY);
//        authorizationService.init();
//        cardTokenService = new CardTokenService(PUBLIC_KEY, PRIVATE_KEY);
//        cardTokenService.init();
//        chargeBackService = new ChargeBackService(PUBLIC_KEY, PRIVATE_KEY);
//        chargeBackService.init();
//        couponService = new CouponService(PUBLIC_KEY, PRIVATE_KEY);
//        couponService.init();
//        customerService = new CustomerService(PUBLIC_KEY, PRIVATE_KEY);
//        customerService.init();
//        depositService = new DepositService(PUBLIC_KEY, PRIVATE_KEY);
//        depositService.init();
//        fraudCheckService = new FraudCheckService(PUBLIC_KEY, PRIVATE_KEY);
//        fraudCheckService.init();
//        invoiceService = new InvoiceService(PUBLIC_KEY, PRIVATE_KEY);
//        invoiceService.init();
//        invoiceItemService = new InvoiceItemService(PUBLIC_KEY, PRIVATE_KEY);
//        invoiceItemService.init();
//        paymentService = new PaymentService(PUBLIC_KEY, PRIVATE_KEY);
//        paymentService.init();
//        planService = new PlanService(PUBLIC_KEY, PRIVATE_KEY);
//        planService.init();
//        refundService = new RefundService(PUBLIC_KEY, PRIVATE_KEY);
//        refundService.init();
//        subscriptionService = new SubscriptionService(PUBLIC_KEY, PRIVATE_KEY);
//        subscriptionService.init();
//        taxService = new TaxService(PUBLIC_KEY, PRIVATE_KEY);
//        taxService.init();
//        transactionReviewService = new TransactionReviewService(PUBLIC_KEY, PRIVATE_KEY);
//        transactionReviewService.init();
//    }
//    
//    private CardToken createCardToken() throws SimplifyCommerceException {
//        System.out.println("------------\nCreate Card Token\n------------");
//        final CardToken cardToken = cardTokenService.createCardToken();
//        System.out.println(cardToken);
//        return cardToken;
//    }
//    
//    private CardToken findCardToken(final String cardTokenId) throws SimplifyCommerceException {
//        System.out.println("------------\nFind Card Token\n------------");
//        final CardToken cardToken = cardTokenService.createCardToken();
//        System.out.println(cardToken);
//        return cardToken;
//    }
//    
//    private Authorization createAuthorization() throws SimplifyCommerceException {
//        System.out.println("------------\nCreate Authorization\n------------");
//        final Authorization authorization = authorizationService.createAuthorization();
//        System.out.println(authorization);
//        return authorization;
//    }
//    
//    private Authorization findAuthorization(final String authorizationId) throws SimplifyCommerceException {
//        System.out.println("------------\nFind Authorization\n------------");
//        final Authorization authorization = authorizationService.findAuthorization(authorizationId);
//        System.out.println(authorization);
//        return authorization;
//    }
//    
//    private List<Authorization> listAuthorizations() throws SimplifyCommerceException {
//        System.out.println("------------\nList Authorizations\n------------");
//        final List<Authorization> authorizations = authorizationService.listAuthorizations();
//        for (final Authorization authorization : authorizations) {
//            System.out.println(authorization);
//        }
//        return authorizations;
//    }
//    
//    private List<Chargeback> listChagebacks() throws SimplifyCommerceException {
//        System.out.println("------------\nList Chargebacks\n------------");
//        final List<Chargeback> chargebacks = chargeBackService.listChargebacks();
//        for (final Chargeback chargeback : chargebacks) {
//            System.out.println(chargeback);
//        }
//        return chargebacks;
//    }
//    
//    private Coupon createCoupon() throws SimplifyCommerceException {
//        System.out.println("------------\nCreate Coupon\n------------");
//        final Coupon coupon = couponService.createCoupon();
//        System.out.println(coupon);
//        return coupon;
//    }
//    
//    private void listCoupons() throws SimplifyCommerceException {
//        System.out.println("------------\nList Coupons\n------------");
//        final List<Coupon> coupons = couponService.listCoupons();
//        for (final Coupon coupon: coupons) {
//            System.out.println(coupon);
//        }
//    }
//    
//    private Coupon findCoupon(final String couponId) throws SimplifyCommerceException {
//        System.out.println("------------\nFind Coupon\n------------");
//        final Coupon coupon = couponService.findCoupon(couponId);
//        System.out.println(coupon);
//        return coupon;
//    }
//    
//    private Coupon updateCoupon(final String couponId, final Map<String, String> props) throws SimplifyCommerceException {
//        System.out.println("------------\nUpdate Coupon\n------------");
//        final Coupon coupon = couponService.updateCoupon(couponId, props);
//        System.out.println(coupon);
//        return coupon;
//    }
//    
//    private Coupon deleteCoupon(final String couponId) throws SimplifyCommerceException {
//        System.out.println("------------\nDelete Coupon\n------------");
//        final Coupon coupon = couponService.deleteCoupon(couponId);
//        System.out.println(coupon);
//        return coupon;
//    }
//    
//    private Customer createCustomer() throws SimplifyCommerceException {
//        System.out.println("------------\nCreate Customer\n------------");
//        final Customer customer = customerService.createCustomer();
//        System.out.println(customer);
//        return customer;
//    }
//    
//    private void listCustomers() throws SimplifyCommerceException {
//        System.out.println("------------\nList Customers\n------------");
//        final List<Customer> customers = customerService.listCustomers();
//        for (final Customer customer: customers) {
//            System.out.println(customer);
//        }
//    }
//    
//    private Customer findCustomer(final String customerId) throws SimplifyCommerceException {
//        System.out.println("------------\nFind Customer\n------------");
//        final Customer customer = customerService.findCustomer(customerId);
//        System.out.println(customer);
//        return customer;
//    }
//    
//    private Customer updateCustomer(final String customerId, final Map<String, String> props) throws SimplifyCommerceException {
//        System.out.println("------------\nUpdate Customer\n------------");
//        final Customer customer = customerService.updateCustomer(customerId, props);
//        System.out.println(customer);
//        return customer;
//    }
//    
//    private Customer deleteCustomer(final String customerId) throws SimplifyCommerceException {
//        System.out.println("------------\nDelete Customer\n------------");
//        final Customer customer = customerService.deleteCustomer(customerId);
//        System.out.println(customer);
//        return customer;
//    }
//
//    private List<Deposit> listDeposits() throws SimplifyCommerceException {
//        System.out.println("------------\nList Deposits\n------------");
//        final List<Deposit> deposits = depositService.listDeposits();
//        
//        for (final Deposit deposit: deposits) {
//            System.out.println(deposit);
//        }
//
//        return deposits;
//    }
//    
//    private Deposit findDeposit(final String depositId) throws SimplifyCommerceException {
//        System.out.println("------------\nFind Deposit\n------------");
//        final Deposit deposit = depositService.findDeposit(depositId);
//        System.out.println(deposit);
//        return deposit;
//    }
//    
//    private Invoice createInvoice() throws SimplifyCommerceException {
//        System.out.println("------------\nCreate Invoice\n------------");
//        final Invoice invoice = invoiceService.createInvoice();
//        System.out.println(invoice);
//        return invoice;
//    }
//    
//    private void listInvoices() throws SimplifyCommerceException {
//        System.out.println("------------\nList Invoices\n------------");
//        final List<Invoice> invoices = invoiceService.listInvoices();
//        for (final Invoice invoice: invoices) {
//            System.out.println(invoice);
//        }
//    }
//    
//    private Invoice findInvoice(final String invoiceId) throws SimplifyCommerceException {
//        System.out.println("------------\nFind Invoice\n------------");
//        final Invoice invoice = invoiceService.findInvoice(invoiceId);
//        System.out.println(invoice);
//        return invoice;
//    }
//    
//    private Invoice updateInvoice(final String invoiceId, final Map<String, String> props) throws SimplifyCommerceException {
//        System.out.println("------------\nUpdate Invoice\n------------");
//        final Invoice invoice = invoiceService.updateInvoice(invoiceId, props);
//        System.out.println(invoice);
//        return invoice;
//    }
//    
//    private Invoice deleteInvoice(final String invoiceId) throws SimplifyCommerceException {
//        System.out.println("------------\nDelete Invoice\n------------");
//        final Invoice invoice = invoiceService.deleteInvoice(invoiceId);
//        System.out.println(invoice);
//        return invoice;
//    }
//    
//    private InvoiceItem createInvoiceItem(final String invoiceId) throws SimplifyCommerceException {
//        System.out.println("------------\nCreate Invoice Item\n------------");
//        final InvoiceItem invoiceItem = invoiceItemService.createInvoiceItem(invoiceId);
//        System.out.println(invoiceItem);
//        return invoiceItem;
//    }
//    
//    private InvoiceItem findInvoiceItem(final String invoiceItemId) throws SimplifyCommerceException {
//        System.out.println("------------\nFind Invoice Item\n------------");
//        final InvoiceItem invoiceItem = invoiceItemService.findInvoiceItem(invoiceItemId);
//        System.out.println(invoiceItem);
//        return invoiceItem;
//    }
//    
//    private InvoiceItem updateInvoiceItem(final String invoiceItemId, final Map<String, String> props) throws SimplifyCommerceException {
//        System.out.println("------------\nUpdate Invoice Item\n------------");
//        final InvoiceItem invoiceItem = invoiceItemService.updateInvoiceItem(invoiceItemId, props);
//        System.out.println(invoiceItem);
//        return invoiceItem;
//    }
//    
//    private InvoiceItem deleteInvoiceItem(final String invoiceItemId) throws SimplifyCommerceException {
//        System.out.println("------------\nDelete Invoice Item\n------------");
//        final InvoiceItem invoiceItem = invoiceItemService.deleteInvoiceItem(invoiceItemId);
//        System.out.println(invoiceItem);
//        return invoiceItem;
//    }
//    
//    private Payment createPayment(final String paymentId) throws SimplifyCommerceException {
//        System.out.println("------------\nCreate Payment\n------------");
//        final Payment payment = paymentService.createPayment(paymentId);
//        System.out.println(payment);
//        return payment;
//    }
//    
//    private void listPayments() throws SimplifyCommerceException {
//        System.out.println("------------\nList Payments\n------------");
//        final List<Payment> payments = paymentService.listPayments();
//        for (final Payment payment: payments) {
//            System.out.println(payment);
//        }
//    }
//    
//    private Payment findPayment(final String paymentId) throws SimplifyCommerceException {
//        System.out.println("------------\nFind Payment\n------------");
//        final Payment payment = paymentService.findPayment(paymentId);
//        System.out.println(payment);
//        return payment;
//    }
//    
//    private Payment updatePayment(final String paymentId, final Map<String, String> props) throws SimplifyCommerceException {
//        System.out.println("------------\nUpdate Payment\n------------");
//        final Payment payment = paymentService.updatePayment(paymentId, props);
//        System.out.println(payment);
//        return payment;
//    }
//    
//    private Plan createPlan() throws SimplifyCommerceException {
//        System.out.println("------------\nCreate Plan\n------------");
//        final Plan plan = planService.createPlan();
//        System.out.println(plan);
//        return plan;
//    }
//    
//    private void listPlans() throws SimplifyCommerceException {
//        System.out.println("------------\nList Plans\n------------");
//        final List<Plan> plans = planService.listPlans();
//        for (final Plan plan: plans) {
//            System.out.println(plan);
//        }
//    }
//    
//    private Plan findPlan(final String invoiceId) throws SimplifyCommerceException {
//        System.out.println("------------\nFind Plan\n------------");
//        final Plan plan = planService.findPlan(invoiceId);
//        System.out.println(plan);
//        return plan;
//    }
//    
//    private Plan updatePlan(final String invoiceId, final Map<String, String> props) throws SimplifyCommerceException {
//        System.out.println("------------\nUpdate Plan\n------------");
//        final Plan plan = planService.updatePlan(invoiceId, props);
//        System.out.println(plan);
//        return plan;
//    }
//    
//    private Plan deletePlan(final String invoiceId) throws SimplifyCommerceException {
//        System.out.println("------------\nDelete Plan\n------------");
//        final Plan plan = planService.deletePlan(invoiceId);
//        System.out.println(plan);
//        return plan;
//    }
//    
//    private Refund createRefund(final String paymentId) throws SimplifyCommerceException {
//        System.out.println("------------\nCreate Refund\n------------");
//        final Refund refund = refundService.createRefund(paymentId);
//        System.out.println(refund);
//        return refund;
//    }
//    
//    private void listRefunds() throws SimplifyCommerceException {
//        System.out.println("------------\nList Refunds\n------------");
//        final List<Refund> refunds = refundService.listRefunds();
//        for (final Refund refund: refunds) {
//            System.out.println(refund);
//        }
//    }
//    
//    private Refund findRefund(final String refundId) throws SimplifyCommerceException {
//        System.out.println("------------\nFind Refund\n------------");
//        final Refund refund = refundService.findRefund(refundId);
//        System.out.println(refund);
//        return refund;
//    }
//    
//    private Subscription createCustomSubscription(final String customerId) throws SimplifyCommerceException {
//        System.out.println("------------\nCreate Custom Subscription\n------------");
//        final Subscription subscription = subscriptionService.createCustomSubscription(customerId);
//        System.out.println(subscription);
//        return subscription;
//    }
//    
//    private Subscription createSubscriptionWithPlan(final String customerId, final String planId) throws SimplifyCommerceException {
//        System.out.println("------------\nCreate Custom Subscription\n------------");
//        final Subscription subscription = subscriptionService.createSubscriptionWithPlan(customerId, planId);
//        System.out.println(subscription);
//        return subscription;
//    }
//    
//    private Subscription createSubscriptionWithPlanAndCoupon(final String customerId, final String planId, final String couponId) throws SimplifyCommerceException {
//        System.out.println("------------\nCreate Custom Subscription\n------------");
//        final Subscription subscription = subscriptionService.createSubscriptionWithPlanAndCoupon(customerId, planId, couponId);
//        System.out.println(subscription);
//        return subscription;
//    }
//    
//    private void listSubscriptions() throws SimplifyCommerceException {
//        System.out.println("------------\nList Subscriptions\n------------");
//        final List<Subscription> subscriptions = subscriptionService.listSubscriptions();
//        for (final Subscription subscription: subscriptions) {
//            System.out.println(subscription);
//        }
//    }
//    
//    private Subscription findSubscription(final String subscriptionId) throws SimplifyCommerceException {
//        System.out.println("------------\nFind Subscription\n------------");
//        final Subscription invoice = subscriptionService.findSubscription(subscriptionId);
//        System.out.println(invoice);
//        return invoice;
//    }
//    
//    private Subscription updateSubscription(final String subscriptionId, final Map<String, String> props) throws SimplifyCommerceException {
//        System.out.println("------------\nUpdate Subscription\n------------");
//        final Subscription subscription = subscriptionService.updateSubscription(subscriptionId, props);
//        System.out.println(subscription);
//        return subscription;
//    }
//    
//    private Subscription deleteSubscription(final String subscriptionId) throws SimplifyCommerceException {
//        System.out.println("------------\nDelete Subscription\n------------");
//        final Subscription subscription = subscriptionService.deleteSubscription(subscriptionId);
//        System.out.println(subscription);
//        return subscription;
//    }
//    
//    private Tax createTax() throws SimplifyCommerceException {
//        System.out.println("------------\nCreate Tax\n------------");
//        final Tax tax = taxService.createTax();
//        System.out.println(tax);
//        return tax;
//    }
//    
//    private void listTaxes() throws SimplifyCommerceException {
//        System.out.println("------------\nList Taxes\n------------");
//        final List<Tax> taxes = taxService.listTaxes();
//        for (final Tax tax: taxes) {
//            System.out.println(tax);
//        }
//    }
//    
//    private Tax findTax(final String invoiceId) throws SimplifyCommerceException {
//        System.out.println("------------\nFind Tax\n------------");
//        final Tax tax = taxService.findTax(invoiceId);
//        System.out.println(tax);
//        return tax;
//    }
//    
//    private Tax deleteTax(final String invoiceId) throws SimplifyCommerceException {
//        System.out.println("------------\nDelete Tax\n------------");
//        final Tax tax = taxService.deleteTax(invoiceId);
//        System.out.println(tax);
//        return tax;
//    }
//
//    private void chargeWithToken() {
//        PaymentsApi.PUBLIC_KEY = PRIVATE_KEY;
//        PaymentsApi.PRIVATE_KEY = PUBLIC_KEY;
//        
//        Payment payment;
//        try {
//            payment = Payment.create(new PaymentsMap()
//                .set("currency", "USD")
//                .set("token", "f21da65e-f0ab-45cb-b8e6-40b493c3671f") // returned by JavaScript call
//                .set("amount", 1000) // In cents e.g. $10.00
//                .set("description", "prod description"));
//            if ("APPROVED".equals(payment.get("paymentStatus"))) {
//                System.out.println("Payment approved");
//            }        
//        } catch (ApiCommunicationException | AuthenticationException | InvalidRequestException | NotAllowedException | SystemException e) {
//            e.printStackTrace();
//        }
//    }
//    
//    private void chargeWithCardDetails() {
//        PaymentsApi.PUBLIC_KEY = PRIVATE_KEY;
//        PaymentsApi.PRIVATE_KEY = PUBLIC_KEY;
//        
//        Payment payment;
//        try {
//            payment = Payment.create(new PaymentsMap()
//                .set("currency", "USD")
//                .set("card.cvc", "123")
//                .set("card.expMonth", 11)
//                .set("card.expYear", 19)
//                .set("card.number", "5555555555554444")
//                .set("amount", 1000) // In cents e.g. $10.00
//                .set("description", "prod description"));
//            if ("APPROVED".equals(payment.get("paymentStatus"))) {
//                System.out.println("Payment approved");
//            }
//        } catch (ApiCommunicationException | AuthenticationException | InvalidRequestException | NotAllowedException | SystemException e) {
//            e.printStackTrace();
//        }
//    }
}
