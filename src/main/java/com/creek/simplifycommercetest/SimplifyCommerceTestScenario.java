package com.creek.simplifycommercetest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.creek.simplifycommercetest.authorization.AuthorizationData;
import com.creek.simplifycommercetest.authorization.AuthorizationDataBuilder;
import com.creek.simplifycommercetest.authorization.AuthorizationService;
import com.creek.simplifycommercetest.cardtoken.CardTokenData;
import com.creek.simplifycommercetest.cardtoken.CardTokenDataFactory;
import com.creek.simplifycommercetest.cardtoken.CardTokenService;
import com.creek.simplifycommercetest.chargeback.ChargeBackService;
import com.creek.simplifycommercetest.coupon.CouponData;
import com.creek.simplifycommercetest.coupon.CouponDataBuilder;
import com.creek.simplifycommercetest.coupon.CouponService;
import com.creek.simplifycommercetest.customer.CustomerData;
import com.creek.simplifycommercetest.customer.CustomerDataBuilder;
import com.creek.simplifycommercetest.customer.CustomerService;
import com.creek.simplifycommercetest.deposit.DepositService;
import com.creek.simplifycommercetest.fraudcheck.FraudCheckService;
import com.creek.simplifycommercetest.invoice.InvoiceService;
import com.creek.simplifycommercetest.invoiceitem.InvoiceItemService;
import com.creek.simplifycommercetest.payment.PaymentData;
import com.creek.simplifycommercetest.payment.PaymentDataBuilder;
import com.creek.simplifycommercetest.payment.PaymentService;
import com.creek.simplifycommercetest.plan.PlanData;
import com.creek.simplifycommercetest.plan.PlanDataBuilder;
import com.creek.simplifycommercetest.plan.PlanService;
import com.creek.simplifycommercetest.refund.RefundData;
import com.creek.simplifycommercetest.refund.RefundDataBuilder;
import com.creek.simplifycommercetest.refund.RefundService;
import com.creek.simplifycommercetest.subscription.SubscriptionData;
import com.creek.simplifycommercetest.subscription.SubscriptionService;
import com.creek.simplifycommercetest.tax.TaxService;
import com.creek.simplifycommercetest.transactionreview.TransactionReviewService;
import com.simplify.payments.exception.ApiException;
import com.simplify.payments.exception.InvalidRequestException;

/**
 * 
 * @author andreypereverzin
 */
public class SimplifyCommerceTestScenario {
    private AuthorizationService authorizationService;
    private CardTokenService cardTokenService;
    private ChargeBackService chargeBackService;
    private CouponService couponService;
    private CustomerService customerService;
    private DepositService depositService;
    private FraudCheckService fraudCheckService;
    private InvoiceService invoiceService;
    private InvoiceItemService invoiceItemService;
    private PaymentService paymentService;
    private PlanService planService;
    private RefundService refundService;
    private SubscriptionService subscriptionService;
    private TaxService taxService;
    private TransactionReviewService transactionReviewService;

    public static void main(final String[] args) throws FileNotFoundException, IOException {
        final SimplifyCommerceTestScenario scenario = new SimplifyCommerceTestScenario();

        final Properties props = new Properties();
        props.load(new FileInputStream("/private/etc/Work1/SimplifyCommerceTest/src/main/resources/config.properties"));

        scenario.init(props);
        
        scenario.runScenario(props);
        //scenario.runCardDeclinedScenario(props);
    }
    
    public void runCardDeclinedScenario(final Properties props) {
        final CardTokenDataFactory cardTokenDataFactory = new CardTokenDataFactory();
        final CardTokenData cardTokenData = cardTokenDataFactory.crateFromProperties(props, "card.number.mc.declined");
        try {
            // Getting a token
            final String cardToken = cardTokenService.provideCardToken(cardTokenData);
            
            // Charging a card
            final PaymentData paymentData = new PaymentDataBuilder().withToken(cardToken).create();
            final PaymentData paymentResponse = paymentService.createPayment(paymentData);
            if (paymentResponse.getPaymentStatus() == PaymentData.PaymentStatus.APPROVED) {
                System.out.println("Payment approved");
            } else { // DECLINED
                System.out.println("Payment declined");
            }
        } catch (final ApiException ex) {
            processException(ex);
        }
    }

    public void runScenario(final Properties props) {
        final CardTokenDataFactory cardTokenDataFactory = new CardTokenDataFactory();
        final CardTokenData cardTokenData = cardTokenDataFactory.crateFromProperties(props, "card.number.mc.approved.approved");

        try {
            // Getting a token
            String cardToken = cardTokenService.provideCardToken(cardTokenData);
            
            // Charging a card
            final PaymentData paymentData = new PaymentDataBuilder().withToken(cardToken).create();
            final PaymentData paymentDataResponse1 = paymentService.createPayment(paymentData);
            if (paymentDataResponse1.getPaymentStatus() == PaymentData.PaymentStatus.APPROVED) {
                System.out.println("Payment approved");
            } else { // DECLINED
                System.out.println("Payment declined");
            }
            
            // Creating a coupon
            final CouponData couponData = new CouponDataBuilder().create();
            final CouponData couponDataResponse = couponService.createCoupon(couponData);
            couponDataResponse.setDescription("new description");
            final CouponData couponDataUpdated = couponService.createCoupon(couponDataResponse);
            
            // Creating a plan
            final PlanData planData = new PlanDataBuilder().create();            
            final PlanData planDataResponse = planService.createPlan(planData);
            
            // Creating a customer and subscribing to a plan
            cardToken = cardTokenService.provideCardToken(cardTokenData);
            final CustomerData customerData = new CustomerDataBuilder().withToken(cardToken).create();
            final List<SubscriptionData> subscriptions = new ArrayList<>();
            final SubscriptionData subscription1 = new SubscriptionData();
            subscription1.setPlan(planDataResponse.getId());
            subscriptions.add(subscription1);
            customerData.setSubscriptions(subscriptions);
            final CustomerData customerResponse = customerService.createCustomer(customerData);
            
            // Refunding a Payment
            final RefundData refundData = new RefundDataBuilder().withPaymentn(paymentDataResponse1.getId()).create();
            final RefundData refundResponse = refundService.createRefund(refundData);
                        
            // Authorization
            cardToken = cardTokenService.provideCardToken(cardTokenData);
            final AuthorizationData authorizationData1 = new AuthorizationDataBuilder().withToken(cardToken).create();
            final AuthorizationData authorizationResponse1 = authorizationService.createAuthorization(authorizationData1);
            
            // Capturing an Authorization
            final PaymentData paymentData2 = new PaymentDataBuilder().withAuthorization(authorizationResponse1.getId()).create();
            final PaymentData paymentDataResponse2 = paymentService.createPayment(paymentData2);
            if (paymentDataResponse2.getPaymentStatus() == PaymentData.PaymentStatus.APPROVED) {
                System.out.println("Payment approved");
            } else { // DECLINED
                System.out.println("Payment declined");
            }
            
            // Authorization
            cardToken = cardTokenService.provideCardToken(cardTokenData);
            final AuthorizationData authorizationData2 = new AuthorizationDataBuilder().withToken(cardToken).create();
            final AuthorizationData authorizationResponse2 = authorizationService.createAuthorization(authorizationData2);
            // Reversing an Authorization
            final AuthorizationData authorizationData2Found = authorizationService.findAuthorization(authorizationResponse2.getId());
            authorizationService.deleteAuthorization(authorizationData2Found.getId());
        } catch (final ApiException ex) {
            processException(ex);
        }
    }

    private void init(final Properties props) throws FileNotFoundException, IOException {
        final String publicKey = props.getProperty("public_key");
        final String privateKey = props.getProperty("private_key");
        authorizationService = new AuthorizationService(publicKey, privateKey);
        authorizationService.init();
        cardTokenService = new CardTokenService(publicKey, privateKey);
        cardTokenService.init();
        chargeBackService = new ChargeBackService(publicKey, privateKey);
        chargeBackService.init();
        couponService = new CouponService(publicKey, privateKey);
        couponService.init();
        customerService = new CustomerService(publicKey, privateKey);
        customerService.init();
        depositService = new DepositService(publicKey, privateKey);
        depositService.init();
        fraudCheckService = new FraudCheckService(publicKey, privateKey);
        fraudCheckService.init();
        invoiceService = new InvoiceService(publicKey, privateKey);
        invoiceService.init();
        invoiceItemService = new InvoiceItemService(publicKey, privateKey);
        invoiceItemService.init();
        paymentService = new PaymentService(publicKey, privateKey);
        paymentService.init();
        planService = new PlanService(publicKey, privateKey);
        planService.init();
        refundService = new RefundService(publicKey, privateKey);
        refundService.init();
        subscriptionService = new SubscriptionService(publicKey, privateKey);
        subscriptionService.init();
        taxService = new TaxService(publicKey, privateKey);
        taxService.init();
        transactionReviewService = new TransactionReviewService(publicKey, privateKey);
        transactionReviewService.init();
    }
    
    private void processException(final ApiException ex) {
        ex.printStackTrace();
        System.out.println("Message:    " + ex.getMessage());
        System.out.println("Reference:  " + ex.getReference());
        System.out.println("Error code: " + ex.getErrorCode());
        if (ex instanceof InvalidRequestException) {
            final InvalidRequestException e2 = (InvalidRequestException) ex;
            if (e2.hasFieldErrors()) {
                for (final InvalidRequestException.FieldError fe : e2.getFieldErrors()) {
                    System.out.println(fe.getFieldName()
                           + ": '" + fe.getMessage()
                           + "' (" + fe.getErrorCode() + ")");
                }
            }
        }
    }
}
