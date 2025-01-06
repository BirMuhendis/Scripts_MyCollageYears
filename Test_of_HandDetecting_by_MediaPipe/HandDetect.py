import cv2
import mediapipe as mp
import logging

# Uyarı loglarını bastır
logging.getLogger('mediapipe').setLevel(logging.ERROR)

# Kamera ayarları
cap = cv2.VideoCapture(0)
cap.set(cv2.CAP_PROP_FRAME_WIDTH, 800)
cap.set(cv2.CAP_PROP_FRAME_HEIGHT, 600)

# Mediapipe araçları
mp_drawing = mp.solutions.drawing_utils
mp_hands = mp.solutions.hands

# El algılama modeli başlangıç ayarları
max_hands = 1
hand = mp_hands.Hands(
    max_num_hands=max_hands,
    min_detection_confidence=0.5,
    min_tracking_confidence=0.5
)

try:
    while True:
        success, frame = cap.read()
        if success:
            # Görüntüyü kareye kırp
            height, width, _ = frame.shape
            size = min(height, width)
            start_x = (width - size) // 2
            start_y = (height - size) // 2
            frame = frame[start_y:start_y + size, start_x:start_x + size]

            # RGB dönüşümü
            RGB_frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)

            # El algılama
            results = hand.process(RGB_frame)

            # İşaret noktalarını çiz
            if results.multi_hand_landmarks:
                for hand_landmarks in results.multi_hand_landmarks:
                    mp_drawing.draw_landmarks(frame, hand_landmarks, mp_hands.HAND_CONNECTIONS)

            # Görüntüyü göster
            cv2.imshow("capture image", frame)

            # '+' tuşu ile max_hands artır ve modeli yeniden başlat
            key = cv2.waitKey(1)
            if key == ord("+"):
                max_hands += 1
                print("Max hands increased to:", max_hands)
                hand = mp_hands.Hands(
                    max_num_hands=max_hands,
                    min_detection_confidence=0.5,
                    min_tracking_confidence=0.5
                )

            # 'q' tuşu ile çıkış
            if key == ord("q"):
                break
finally:
    # Kaynakları serbest bırak
    cap.release()
    cv2.destroyAllWindows()
