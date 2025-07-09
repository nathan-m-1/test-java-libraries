package com.example.flowapi;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class FlowObserverPattern {

    public static void main(String[] args) throws Exception {
        // 1. Crear el publisher
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        // 2. Crear el subscriber
        Flow.Subscriber<String> subscriber = new Flow.Subscriber<>() {
            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                System.out.println("🔗 Suscrito");
                subscription.request(1); // Pedimos el primer dato
            }

            @Override
            public void onNext(String item) {
                System.out.println("📥 Recibido: " + item);
                subscription.request(1); // Pedimos el siguiente
            }

            @Override
            public void onError(Throwable throwable) {
                System.err.println("❌ Error: " + throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("✅ Completado");
            }
        };

        // 3. Conectar el subscriber al publisher
        publisher.subscribe(subscriber);

        // 4. Publicar algunos datos
        publisher.submit("Hola");
        publisher.submit("Mundo");

        // 5. Cerrar el publisher (avisa que no habrá más datos)
        publisher.close();

        // 6. Esperar un poco para ver el resultado antes de que termine el programa
        Thread.sleep(1000);
    }
}
