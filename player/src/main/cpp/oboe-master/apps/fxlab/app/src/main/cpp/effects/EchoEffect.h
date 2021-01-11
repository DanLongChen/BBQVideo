/*
 * Copyright  2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
#ifndef ANDROID_FXLAB_ECHOEFFECT_H
#define ANDROID_FXLAB_ECHOEFFECT_H

#include "DelayLineEffect.h"
#include "utils/WhiteNoise.h"


template <class iter_type>
class EchoEffect: public DelayLineEffect<iter_type> {
public:
    EchoEffect(float feedback, float delay_ms):
        DelayLineEffect<iter_type> {1, 0, feedback,
            static_cast<int>(delay_ms * SAMPLE_RATE / 1000),
            0,
            std::function<float()>{[](){return 0.0;}}}
    {}
};
#endif //ANDROID_FXLAB_ECHOEFFECT_H
